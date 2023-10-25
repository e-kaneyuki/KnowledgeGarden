package model;

import java.io.Serializable;

public class Answer implements Serializable {
	private int id;
	private String content;
	private int answererId;
	private int questionId;
	private String answererName;
	
	public Answer(int id, String content,int answererId, int questionId) {
		this.id = id;
		this.content = content;
		this.answererId = answererId;
		this.questionId = questionId;
	}

	public Answer(int id, String content,int answererId, int questionId, String answererName) {
		this.id = id;
		this.content = content;
		this.answererId = answererId;
		this.questionId = questionId;
		this.answererName = answererName;
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
	
	public String getAnswererName() {
		return answererName;
	}	
	
}
