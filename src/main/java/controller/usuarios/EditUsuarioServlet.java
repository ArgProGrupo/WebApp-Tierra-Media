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

@WebServlet("/usuarios/editUsuarios.adm")
public class EditUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -5703845683601259788L;

	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Usuario tmp_usuario = usuarioService.findById(id);
		req.setAttribute("tmp_usuario", tmp_usuario);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/editUsuarios.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("username");
		String password = req.getParameter("password");
		Boolean admin = Boolean.parseBoolean("admin");  // Da problemas a la hora de editar
		String tipoAtraccion = req.getParameter("tipoAtraccion");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		Boolean active = Boolean.parseBoolean(req.getParameter("active"));


		Usuario temp_user = usuarioService.update(id, nombre, password, admin, tipoAtraccion , presupuesto, tiempoDisponible, active);

		if (temp_user.isValid()) {
			resp.sendRedirect("/TierraMediaWeb/usuarios/usuarios.adm");
		} else {
			req.setAttribute("temp_user", temp_user);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TierraMediaWeb/usuarios/editUsuarios.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
