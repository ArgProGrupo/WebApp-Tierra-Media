package controller.usuarios;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.FactoryDAO;
import persistence.impl.AtraccionDAOImpl;
import services.UsuarioService;

@WebServlet("/usuarios/usuarios.adm")
public class MostrarUsuariosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -5158378959933399013L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.list();
		for(Usuario u : usuarios) {
		u.setItinerarioUsuario(((AtraccionDAOImpl) FactoryDAO.getAtraccionDAO()).findItineario(u.getIdUsuario()));
		}
		req.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/usuarios.jsp");
		dispatcher.forward(req, resp);
	}
}