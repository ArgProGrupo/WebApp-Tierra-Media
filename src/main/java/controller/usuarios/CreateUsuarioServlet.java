package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/create.do")
public class CreateUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -2821821443971474022L;
	
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/nuevoUsuario.jsp"); //poner ruta correcta
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("username");
		String password = req.getParameter("password");
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
		String tipoAtraccion = req.getParameter("tipoAtraccion");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		Boolean active = Boolean.parseBoolean(req.getParameter("active"));
		

		Usuario tmp_user = usuarioService.create(nombre, password, admin, tipoAtraccion, presupuesto, tiempoDisponible, active);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("/TierraMediaWeb/usuarios.jsp");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
