package controller.propuestas;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/atracciones/borrarAtraccion.adm")
public class BorrarAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -2821548431939808584L;
	private AtraccionService atraccionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccion = atraccionService.findById(id);
		req.setAttribute("atraccion", atraccion);
		atraccionService.delete(atraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/atracciones.jsp");
		dispatcher.forward(req, resp);
	}
}