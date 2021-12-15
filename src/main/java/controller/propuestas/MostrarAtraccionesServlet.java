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
import model.ComparadorDeAtracciones;
import model.Propuestas;
import model.Usuario;
import services.AtraccionService;

@WebServlet("/atracciones/atracciones.do")
public class MostrarAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -6719722765612521298L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Propuestas> atracciones = atraccionService.list();
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		atracciones.sort(new ComparadorDeAtracciones(usuario.getTipoAtraccionFavorita()));
		
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/atracciones.jsp");
		
		dispatcher.forward(req, resp);
	}
}