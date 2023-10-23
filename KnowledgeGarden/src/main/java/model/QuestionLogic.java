package model;

import dao.QuestionDAO;

public class QuestionLogic {
	public boolean execute(QuestionRegistration questionRegistration) {
		QuestionDAO dao = new QuestionDAO();
		int count = dao.insertQuestion(questionRegistration);
		return count != 0;
	}
	public Question showQuestion(int questionId) {
		QuestionDAO dao = new QuestionDAO();
		Question question = dao.getQuestionById(questionId);
		return question;
	}
}
