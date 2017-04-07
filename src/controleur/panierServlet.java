package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import serviceImpl.ProductManager;


public class panierServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductManager manager = new ProductManager();
			
			List<Product> panier = manager.getProduct();
			request.setAttribute("product", panier);
			
			request.getRequestDispatcher("WEB-INF/views/panier.jsp").forward(request, response);
		
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		
	}
		
}
