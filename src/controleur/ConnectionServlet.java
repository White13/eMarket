package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;
import dto.User;
import service.IUserManager;
import serviceImpl.UserManager;

/**
 * Servlet implementation class ConnectionServlet
 */

public class ConnectionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IUserManager userManager = new UserManager();
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		User user = userManager.authenticate(login, pwd);

		if (user != null) {

			if (user.getRole().equals("Commerciale")) {
				HttpSession session = request.getSession();
				session.setAttribute("identification", "OK admin");
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/AccueilAdm.jsp").forward(request,
						response);

			} else {
				HttpSession session = request.getSession();
				session.setAttribute("identification", "OK");
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/AccueilInt.jsp").forward(request,
						response);
			}

		} else {
			boolean error = true;
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.getAttribute("identification") == "OK") {
			try {
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/AccueilInt.jsp").forward(request,
						response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
		} else if (session.getAttribute("identification") == "OK admin") {
			try {
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/AccueilAdm.jsp").forward(request,
						response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
		} else {
			try {
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
		}

	}

}
