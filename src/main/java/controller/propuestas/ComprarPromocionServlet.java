package controller.propuestas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Propuestas;
import model.Usuario;
import persistence.commons.FactoryDAO;
import services.AtraccionService;
import services.ComprarAtraccionService;
import services.ComprarPromocionService;
import services.PromocionService;

@WebServlet("/comprarPromo.do")
public class ComprarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7128945132797889313L;
	private ComprarPromocionService comprarPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarPromocionService = new ComprarPromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		
		Map<String, String> errores = comprarPromocionService.comprar(usuario.getIdUsuario(), promocionId);
		
		Usuario usuario2 = FactoryDAO.getUsuarioDAO().findByIdUsuario(usuario.getIdUsuario());
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errores.isEmpty()) {
			req.setAttribute("flash", "COMPRADO");
		} else {
			req.setAttribute("flash", "Error al comprar");
			req.setAttribute("errores", errores);
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/catalogo.jsp");
		
		dispatcher.forward(req, resp);

	}

}