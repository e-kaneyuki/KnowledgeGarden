package model;

import java.io.Serializable;

public class AnswerRegistration implements Serializable{
	
	private String content;
	private int userId;
	private int questionId;
	//登録用
	public AnswerRegistration(String content, int userId, int questionId) {
		this.content = content;
		this.userId = userId;
		this.questionId = questionId;
	}
    //show画面一覧取得用
	public AnswerRegistration(int questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}
	
	public int getUserId() {
		return userId;
	}

	public int getQuestionId() {
		return questionId;
	}
	

}
