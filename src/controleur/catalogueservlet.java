package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import serviceImpl.ProductManager;


public class catalogueservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		
		
		try {
			ProductManager manager = new ProductManager();
			
			List<Product> listProduct = manager.getProduct();
			request.setAttribute("product", listProduct);
			
			request.getRequestDispatcher("WEB-INF/views/catalogue.jsp").forward(request, response);
		
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
