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
	
	//SELECT
	public User authenticate(int userID, String userName, String password) {
		User user = null;		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT"
					+ " ID,"
					+ " NAME,"
					+ " PASSWORD"
					+ " FROM"
					+ " Users"
					+ " WHERE"
					+ " ID = ?"
					+ " AND"
					+ " Name = ?"
					+ " AND"
					+ " PASSWORD = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userID);  // 1番目の?にuserIDの値をセット
			pStmt.setString(2, userName);  // 2番目の?にuserNameの値をセット
			pStmt.setString(3, password);  // 3番目の?にpasswordの値をセット


			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASSWORD");
				
				user = new User(id, name, pass);
				
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
