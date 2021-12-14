package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.LoginService;

@WebServlet("/ingresar")
public class LoginServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7108188191383967488L;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("username");
		String password = req.getParameter("password");

		Usuario usuario = loginService.login(nombre, password);

		if (!usuario.isNull()) {
			req.getSession().setAttribute("usuario", usuario);
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("flash", "usuario y/o contraseña incorrecta");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ingresar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
