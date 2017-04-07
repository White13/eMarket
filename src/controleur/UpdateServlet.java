package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import serviceImpl.ProductManager;

/**
 * Servlet implementation class UpdateServlet
 */

public class UpdateServlet extends HttpServlet {
	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int id = -1;
			double price = -1;
			id = Integer.parseInt(request.getParameter("id"));
			price = Double.parseDouble(request.getParameter("sellingPrice"));
			
			if (id == -1 || price == -1) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Empty name");
				return;
			}
			
			
			ProductManager manager = new ProductManager();
			manager.updateProduct(id, price);
			List<Product> listProduct = manager.getProduct();
			
			request.setAttribute("product", listProduct);
			
			try {
				request.getRequestDispatcher("/WEB-INF/views/catalogue.jsp").forward(request,response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
	}

}
