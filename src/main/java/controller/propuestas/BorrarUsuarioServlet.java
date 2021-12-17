package controller.propuestas;

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

@WebServlet("/usuarios/borrarUsuario.adm")
public class BorrarUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1854507212890311557L;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = usuarioService.findById(id);
		req.setAttribute("atraccion", usuario);
		usuarioService.delete(usuario.getIdUsuario());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/usuarios.jsp");
		dispatcher.forward(req, resp);
	}
}