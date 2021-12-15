package controller.propuestas;

import java.io.IOException;
import java.util.List;

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
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/comprar")
public class ComprarAtraccionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -1500626018984218236L;
	
	private AtraccionService atraccionService;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Propuestas> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		Atraccion atraccion = (Atraccion) req.getSession().getAttribute("atraccion");
		
		Promocion promocion = (Promocion) req.getSession().getAttribute("promocion");
		
		if(usuario.puedeComprar(atraccion)){
			usuario.comprarPropuesta(atraccion);
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/catalogo.jsp");
		
		dispatcher.forward(req, resp);

	}

}