package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import dto.Catalogue;
import dto.Commerciale;
import dto.Internaute;
import dto.Product;
import jdbc.JDBCExample;
import service.IProductManager;

public class ProductManager implements IProductManager {

	// private DataSource ds;
	Connection connection = null;
	// Context initContext;

	@Override

	public void createProduct(Catalogue catalogue, String name, double price, String description) {

		/*
		 * try { initContext= new InitialContext(); Context envContext =
		 * (Context) initContext.lookup("java:comp/env"); DataSource ds =
		 * (DataSource) envContext.lookup("jdbc/eboutiqueDB"); connection =
		 * ds.getConnection();
		 */

		try {
			connection = JDBCExample.getConnection();

			String sql = "INSERT INTO Product (name_product, selling_price) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// spécifier le SQL CIBLE
			statement.setString(1, name);
			statement.setDouble(2, price);
			int nbLignes = statement.executeUpdate(); // retourne nombre de
														// lignes
			int id = 0;
			if (nbLignes != 0) {

				ResultSet rs = statement.getGeneratedKeys();
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}
			connection.close();
			Product prod = new Product(id, name, price, description);

			// objet catalogue

			catalogue.getListProduct().add(prod);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public List<Product> getProduct() {

		try {
			List<Product> listProduct = new ArrayList<Product>();
			connection = JDBCExample.getConnection();

			if (connection != null) {
				PreparedStatement prep;

				prep = (PreparedStatement) connection.prepareStatement("SELECT * FROM Product");
				ResultSet rs = prep.executeQuery();

				while (rs.next()) {

					int id = rs.getInt("id");
					String nom = rs.getString("name_product");
					double prix = rs.getDouble("selling_price");
					String description = rs.getString("description");
					listProduct.add(new Product(id, nom, prix, description));
				}

				return listProduct;
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}
		return null;
	}

	@Override
	public void deletedProduct(int id) {

		try {
			connection = JDBCExample.getConnection();
			/*
			 * initContext= new InitialContext(); Context envContext = (Context)
			 * initContext.lookup("java:comp/env"); DataSource ds = (DataSource)
			 * envContext.lookup("jdbc/eboutiqueDB"); connection =
			 * ds.getConnection();
			 */

			String sql = "DELETE FROM product WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			int nbLignes = statement.executeUpdate();

			connection.close();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(int id, double sellingPrice) {

		try {
			connection = JDBCExample.getConnection();
			/*
			 * initContext= new InitialContext(); Context envContext = (Context)
			 * initContext.lookup("java:comp/env"); DataSource ds = (DataSource)
			 * envContext.lookup("jdbc/eboutiqueDB"); connection =
			 * ds.getConnection();
			 */

			String sql = "update product set selling_price=? where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setDouble(2, sellingPrice);

			int nbLignes = statement.executeUpdate();

			connection.close();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public List<String> details(String idProduct) {

		try {
			connection = JDBCExample.getConnection();
			List<String> details = new ArrayList<String>();

			if (connection != null) {
				PreparedStatement prep;

				prep = (PreparedStatement) connection.prepareStatement(
						"select p.id, p.description, p.name_product, c.name_component, phc.quantity, p.selling_price FROM product as p inner join product_has_component as phc on (p.id = phc.product_id) inner join component as c on (c.id = phc.component_id) where p.id = ?");
				prep.setString(1, idProduct);
				ResultSet rs = prep.executeQuery();

				while (rs.next()) {

					details.add(rs.getString("id"));
					details.add(rs.getString("description"));
					details.add(rs.getString("name_product"));
					details.add(rs.getString("selling_price"));
					details.add(rs.getString("name_component"));
					
					
				}

				return details;
			}
			connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}
		return null;
	}
}
