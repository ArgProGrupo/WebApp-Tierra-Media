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

@WebServlet("/atracciones/edit.adm")
public class EditAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1415035798193281836L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccion = atraccionService.findById(id); //agregar metodo al AtraccionService
		req.setAttribute("atraccion", atraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipoAtraccion = req.getParameter("tipoAtraccion");


		Atraccion atraccion = atraccionService.update(id, nombre, costo, tiempo, cupo , tipoAtraccion);

		if (atraccion.isValid()) {
			resp.sendRedirect("/TierraMediaWeb/atracciones.adm");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
