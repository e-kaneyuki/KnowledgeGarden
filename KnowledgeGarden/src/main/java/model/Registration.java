package model;

import java.io.Serializable;

public class Registration implements Serializable{
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
