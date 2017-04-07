package controleur;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * Servlet implementation class ValiderPanierServlet
 */

public class ValiderPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			JSONObject jObj = new JSONObject(request.getParameter("panier"));

			Iterator<?> it = jObj.keys(); //gets all the keys

			while(it.hasNext())
			{
			    Object key = it.next(); // get key
			    JSONObject o = (JSONObject) jObj.get(key.toString()); // get value
			    System.out.println(key + " : " +  o); // print the key and value
			    System.out.println(o.get("nom")); // print the key and value
			}	

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.setContentType("text/plain");
		//response.setCharacterEncoding("UTF-8");
		//response.getWriter().write("OK");
		
	}

}
