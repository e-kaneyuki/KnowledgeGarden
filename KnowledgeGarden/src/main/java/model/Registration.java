package model;

public class Registration {
	private int id;
	private String name;
	private String pass;
	
	public Registration(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
	
	
}
