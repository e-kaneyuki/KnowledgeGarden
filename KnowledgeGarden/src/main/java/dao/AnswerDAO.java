package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.AnswerRegistration;
import model.Question;

public class AnswerDAO {
	private final String JDBC_URL = "jdbc:h2:~/knowledgeGarden";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	
	
	public List<Answer> findAnswerById(int queId) {
		List<Answer> answers = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "SELECT" 
				+ " A.ID,"
				+ " A.CONTENT,"
				+ " A.ANSWERER_ID,"
				+ " A.QUESTION_ID," 
				+ " U.NAME"
				+ " FROM" 
				+ " ANSWERS A" 
				+ " INNER JOIN" 
				+ " USERS U ON A.ANSWERER_ID = U.ID" 
				+ " WHERE" 
				+ " A.QUESTION_ID ="
				+ queId;


			PreparedStatement pStmt = conn.prepareStatement(sql);

			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Question question = null;
				int AnswerId = rs.getInt("ID");
				String AnswerContent = rs.getString("CONTENT");
				int AnswererId = rs.getInt("ANSWERER_ID");
				int questionId = rs.getInt("QUESTION_ID");
				String AnswererName = rs.getString("NAME");
				Answer answer = new Answer(AnswerId, AnswerContent, AnswererId, questionId, AnswererName);
				answers.add(answer);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
//		for (Question question: questions) {
//			System.out.println(question.getUser());
//		}
		return answers;
	}
	
	//INSERTする
	public int insertAnswer(AnswerRegistration ansReg) {
//		Question question = null;
		int rowsCount = 0;

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO"
					+ " answers(CONTENT, ANSWERER_ID, QUESTION_ID)" 
					+ " VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, ansReg.getContent());
			pStmt.setInt(2, ansReg.getUserId());
			
			pStmt.setInt(3, ansReg.getQuestionId());

			rowsCount = pStmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsCount;
	}
}
