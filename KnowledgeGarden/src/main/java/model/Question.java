package model;

import java.io.Serializable;

public class Question implements Serializable {
	private int id;
	private String title;
	private String content;
	private User user;
 
	public Question(int id, String title, String content, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	} 

}
