package model;

import java.util.List;

import dao.QuestionDAO;

public class QuestionLogic {
	//insert
	public boolean execute(QuestionRegistration questionRegistration) {
		QuestionDAO dao = new QuestionDAO();
		int count = dao.insertQuestion(questionRegistration);
		return count != 0;
	}
	//index
	public List<Question> execute() {
		QuestionDAO dao = new QuestionDAO();
		List<Question> questionList = dao.findAllQuestion();
		return questionList;
	}
	//show
	public Question showQuestion(int questionId) {
		QuestionDAO dao = new QuestionDAO();
		Question question = dao.getQuestionById(questionId);
		return question;
	}
	
	//delete
		public boolean deleteQuestion(int questionId) {
			QuestionDAO dao = new QuestionDAO();
			int count = dao.deleteQuestion(questionId);
			return count != 0;
		}
}
