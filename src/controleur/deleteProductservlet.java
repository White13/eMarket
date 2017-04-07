package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Catalogue;
import dto.Product;
import serviceImpl.ProductManager;

/**
 * Servlet implementation class deleteProductservlet
 */

public class deleteProductservlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = -1;
		id = Integer.parseInt(request.getParameter("id"));
		
		if (id == -1) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Empty name");
			return;
		}
		
		
		ProductManager manager = new ProductManager();
		manager.deletedProduct(id);
		List<Product> listProduct = manager.getProduct();
		request.setAttribute("product", listProduct);
		
		
		try {
			request.getRequestDispatcher("/WEB-INF/views/catalogue.jsp").forward(request,response);
		
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.getAttribute("identification") == "OK") {
			try {
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/AccueilInt.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				
				
				e.printStackTrace();
			}
		}else if (session.getAttribute("identification") == "OK admin") {
			try {
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/AccueilAdm.jsp").forward(request, response);
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
