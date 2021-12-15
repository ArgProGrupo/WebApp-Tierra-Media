package controller.propuestas;

import java.io.IOException;
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
import services.PromocionService;

@WebServlet("/comprar.do")
public class ComprarAtraccionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -1500626018984218236L;
	
	private ComprarAtraccionService comprarAtraccionServicer;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarAtraccionServicer = new ComprarAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Integer atraccionId = Integer.parseInt(req.getParameter("id"));
		
		Map<String, String> errores = comprarAtraccionServicer.comprar(usuario.getIdUsuario(), atraccionId);
		
		Usuario usuario2 = FactoryDAO.getUsuarioDAO().findByIdUsuario(usuario.getIdUsuario());
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errores.isEmpty()) {
			req.setAttribute("flash", "COMPRADO");
		} else {
			req.setAttribute("Flash", "Error al comprar");
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/catalogo.jsp");
		
		dispatcher.forward(req, resp);

	}

}