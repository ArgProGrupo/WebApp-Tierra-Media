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
import model.Propuestas;
import services.AtraccionService;
import services.PromocionService;

// Editar usuario tiene que llevar a http://localhost:8080/TierraMediaWeb/usuarios.do
@WebServlet("/catalogo.do")
public class MostrarCatalogoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -6719722765612521298L;
	private AtraccionService atraccionService;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}
	
//	List<Propuestas> atracciones = atraccionService.list();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Propuestas> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);
		
		List<Propuestas> promociones = promocionService.list(atracciones);
		req.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/catalogo.jsp");
		
//		RequestDispatcher dispatcher2 = getServletContext()
//				.getRequestDispatcher("/catalogo.jsp");
		
//		dispatcher2.forward(req, resp);
		
//		"/TierraMediaWeb/usuarios.jsp"
		
		dispatcher.forward(req, resp);
		

	}
	
//	public static void main(String[] args) throws ServletException {
//		MostrarAtraccionesServlet a = new MostrarAtraccionesServlet();
//		a.init();
//		System.out.println(a.atracciones);	}

}