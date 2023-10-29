package model;

import dao.UserDAO;

public class UserLogic {
	public User login(int userID, String userName, String password) {
		UserDAO dao = new UserDAO();
		User user = dao.authenticate(userID, userName, password);
		return user; 
	}
}
