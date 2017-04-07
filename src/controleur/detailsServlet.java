package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import serviceImpl.ProductManager;


public class detailsServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductManager manager = new ProductManager();
			String idProduct = request.getParameter("idProduct");
			
			List<String> details = manager.details(idProduct);
			
			request.setAttribute("details", details);
			request.getRequestDispatcher("/WEB-INF/views/details.jsp").forward(request,response);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
