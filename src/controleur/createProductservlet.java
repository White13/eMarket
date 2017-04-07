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
import service.IProductManager;
import serviceImpl.ProductManager;

/**
 * Servlet implementation class createProduct
 */

public class createProductservlet extends HttpServlet {
	     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Catalogue cat = new Catalogue ();
		ProductManager manager = new ProductManager();
		
		String name = request.getParameter("nom");
		Double price = Double.parseDouble(request.getParameter("sellingPrice"));
		String description = request.getParameter("description");
				
		manager.createProduct(cat, name, price, description);
		//appelle de la methode getproduct()
		List<Product> listProduct = manager.getProduct();
		request.setAttribute("product", listProduct);
		
		request.getRequestDispatcher("WEB-INF/views/catalogue.jsp").forward(request, response);
		
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
