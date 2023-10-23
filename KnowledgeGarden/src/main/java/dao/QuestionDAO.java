package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.QuestionRegistration;
import model.User;

public class QuestionDAO {
	private final String JDBC_URL = "jdbc:h2:~/knowledgeGarden";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
//	これはSELECT
	public List<Question> findAllQuestion() {
		List<Question> questions = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
//			String sql = "SELECT * FROM QUESTIONS";
			String sql = "SELECT"
			 +" Q.ID AS QUESTION_ID,"
			 +" Q.TITLE AS QUESTION_TITLE,"
			 +" Q.CONTENT AS QUESTION_CONTENT,"
			 +" Q.QUESTIONER_ID,"
			 +" Q.DATE_POSTED,"
			 +" U.NAME AS QUESTIONER_NAME"
			 +" FROM"
			 +" QUESTIONS Q"
			 +" INNER JOIN"
			 +" USERS U"
			 +" ON"
			 +" Q.QUESTIONER_ID = U.ID;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Question question = null;
				int questionId = rs.getInt("QUESTION_ID");
				String questionTitle = rs.getString("QUESTION_TITLE");
				String questionContent = rs.getString("QUESTION_CONTENT");
				
				int userId = rs.getInt("QUESTIONER_ID");
				String userName = rs.getString("QUESTIONER_NAME");
				User user = new User(userId, userName);
				question = new Question(questionId, questionTitle, questionContent, user);
				questions.add(question);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
//		for (Question question: questions) {
//			System.out.println(question.getUser());
//		}
		return questions;
	}
	
	public Question getQuestionById(int questionId) {
		Question question = null;
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
//			String sql = "SELECT * FROM QUESTIONS";
			String sql = "SELECT " 
					+ "Q.ID AS QUESTION_ID, " 
					+ "Q.TITLE AS QUESTION_TITLE, " 
					+ "Q.CONTENT AS QUESTION_CONTENT, " 
					+ "Q.QUESTIONER_ID, " 
					+ "Q.DATE_POSTED, " 
					+ "U.NAME AS QUESTIONER_NAME " 
					+ "FROM " 
					+ "QUESTIONS Q " 
					+ "INNER JOIN " 
					+ "USERS U " 
					+ "ON " 
					+ "Q.QUESTIONER_ID = U.ID " 
					+ "WHERE " 
					+ "Q.ID = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			int queId = questionId;
			pStmt.setInt(1, queId);
			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("QUESTION_ID");
				String questionTitle = rs.getString("QUESTION_TITLE");
				String questionContent = rs.getString("QUESTION_CONTENT");
				
				int userId = rs.getInt("QUESTIONER_ID");
				String userName = rs.getString("QUESTIONER_NAME");
				User user = new User(userId, userName);
				question = new Question(id, questionTitle, questionContent, user);
			}
			return question;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
//	INSERTする
	public int insertQuestion(QuestionRegistration queReg) {
//		Question question = null;
		int rowsCount = 0;
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO"
					+ " questions(TITLE, CONTENT, QUESTIONER_ID)" 
					+ " VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, queReg.getTitle());
			pStmt.setString(2, queReg.getContent());
			pStmt.setInt(3, queReg.getUserId());
			
			rowsCount = pStmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsCount;
	}
}
