package controller.propuestas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;
import java.io.IOException;

@WebServlet("/atracciones/create.adm")
public class CreateAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7847854359206650880L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipoAtraccion = req.getParameter("tipoAtraccion");


		Atraccion atraccion = atraccionService.create(nombre, costo,tiempo, cupo , tipoAtraccion);

		if (atraccion.isValid()) {
			resp.sendRedirect("/TierraMediaWeb/atracciones/atracciones.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TierraMediaWeb/atracciones/create.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
