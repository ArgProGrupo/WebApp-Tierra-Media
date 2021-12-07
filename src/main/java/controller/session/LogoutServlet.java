package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1456114303170678288L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("username");
		
		req.setAttribute("flash", "Gracias, vuelvas prontos");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ingresar.jsp");
		dispatcher.forward(req, resp);
	}
}
