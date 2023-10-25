package model;

import java.io.Serializable;

public class Answer implements Serializable {
	private int id;
	private String content;
	private int answererId;
	private int questionId;
	
	public Answer(int id, String content,int answererId, int questionId) {
		this.id = id;
		this.content = content;
		this.answererId = answererId;
		this.questionId = questionId;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public int getAnswererId() {
		return answererId;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	
	
	
}
