package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import dto.Internaute;
import dto.Commerciale;
import dto.Product;
import dto.User;
import jdbc.JDBCExample;
import service.IUserManager;

public class UserManager implements IUserManager {

	public User authenticate(String login, String pwd) {

		Context iniContext;

		try {
			Connection connection = JDBCExample.getConnection();
			PreparedStatement prep;
			String sql = "select group_id FROM user_has_group as u inner join emarket_user as e on u.login=e.login Where e.login=? and e.password=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, pwd);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				String group = rs.getString("group_id");
				if (group.equals("Commerciaux")) {
					return (new Commerciale());
				} else {
					return (new Internaute());
				}
			}
			return null;

			/*
			 * try { Connection connection = JDBCExample.getConnection();
			 * 
			 * boolean found = false; if (connection != null) {
			 * PreparedStatement prep; String sql =
			 * "select * FROM emarket_user where login=?"; PreparedStatement
			 * statement = connection.prepareStatement(sql);
			 * statement.setString(1, login); ResultSet rs =
			 * statement.executeQuery();
			 * 
			 * while (rs.next()) { String loginBD = rs.getString("login");
			 * String pwdBD = rs.getString("password"); if
			 * (login.equals(loginBD) && pwd.equals(pwdBD)) { found = true; } }
			 * 
			 * if (found) { sql = "select * FROM user_has_group where login=?";
			 * statement = connection.prepareStatement(sql);
			 * statement.setString(1, login); rs = statement.executeQuery();
			 * String group = "0"; while (rs.next()) { group =
			 * rs.getString("group_id"); } if (!group.equals("0")) { if
			 * (group.equals("Commerciaux")) { return (new Commerciale()); }
			 * else { return (new Internaute()); } }
			 * 
			 * }
			 * 
			 * connection.close();
			 * 
			 * }
			 */
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return null;

	}
}
