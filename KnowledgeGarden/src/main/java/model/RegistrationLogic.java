package model;

import dao.UserDAO;

public class RegistrationLogic {
	public boolean execute(Registration registration) {
		UserDAO dao = new UserDAO();
		int count = dao.insertRegistration(registration);
		return count != 0;
	}
	
}
