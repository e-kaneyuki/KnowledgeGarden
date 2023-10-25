package model;

import dao.UserDAO;

public class UserLogic {
	public User login(int id, String password) {
		UserDAO dao = new UserDAO();
		User user = dao.authenticate(id, password);
		return user; 
	}
}
