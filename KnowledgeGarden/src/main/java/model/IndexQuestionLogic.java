package model;

import java.util.List;

import dao.IndexQuestionDAO;

public class IndexQuestionLogic {
	public List<Question> execute() {
		IndexQuestionDAO dao = new IndexQuestionDAO();
		List<Question> questionList = dao.findAllQuestion();
		return questionList;
	}
}
