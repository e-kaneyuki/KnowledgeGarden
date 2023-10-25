package model;

import java.util.List;

import dao.AnswerDAO;

public class AnswerLogic {
	public boolean execute(AnswerRegistration answerRegistration) {
		AnswerDAO dao = new AnswerDAO();
		
		int count = dao.insertAnswer(answerRegistration);
		return count != 0;
	}
	
	public List<Answer> findAnswerById(int queId) {
		
		AnswerDAO dao = new AnswerDAO();
		List<Answer> ansList = dao.findAnswerById(queId);
		
		return ansList;
	}
}
