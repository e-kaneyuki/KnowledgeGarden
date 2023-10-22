package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Registration;
import model.User;

public class UserDAO {
	
	private final String JDBC_URL = "jdbc:h2:~/knowledgeGarden";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
//	これはSELECT
	public User findByRegistration(Registration registration) {
		User user = null;
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID, NAME, PASS FROM USERS WHERE ID = ? AND NAME = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, registration.getId());
			pStmt.setString(2, registration.getName());
			pStmt.setString(3, registration.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				
				user = new User(userId, name, pass);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
//	INSERTする
	public int insertRegistration(Registration registration) {
		User user = null;
		int rowsCount = 0;
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO"
					+ " users(ID, NAME, PASSWORD)" 
					+ " VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, registration.getId());
			pStmt.setString(2, registration.getName());
			pStmt.setString(3, registration.getPass());
			
			rowsCount = pStmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsCount;
	}
	
}
