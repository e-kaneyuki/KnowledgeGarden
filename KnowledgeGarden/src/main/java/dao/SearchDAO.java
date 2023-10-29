package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.User;

public class SearchDAO {
	private final String JDBC_URL = "jdbc:h2:~/knowledgeGarden";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";


    public List<Question> searchQuestions(String questionTitle) {
    	List<Question> questions = new ArrayList<Question>(); 
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
        	
            // 基本のSQLクエリを定義
        	String sql = "SELECT " +
        		    "Questions.ID AS QUESTION_ID, " +
        		    "Questions.TITLE AS QUESTION_TITLE, " +
        		    "Questions.CONTENT AS QUESTION_CONTENT, " +
        		    "Questions.QUESTIONER_ID, " +
        		    "Users.ID AS USER_ID, " +
        		    "Users.NAME AS QUESTIONER_NAME " +
        		    "FROM Questions " +
        		    "INNER JOIN Users ON Users.ID = Questions.QUESTIONER_ID " +
        		    "WHERE Questions.TITLE LIKE ?"; // タイトルによる部分一致検索を行います


        		// PreparedStatementを使用してSQLクエリをセットアップ
        		PreparedStatement statement = conn.prepareStatement(sql);

        		// プレースホルダーに値を設定
        		if (questionTitle != null && !questionTitle.isEmpty()) {
        		    statement.setString(1, "%" + questionTitle + "%"); // 1はプレースホルダーのインデックス
        		}

        		// SQLクエリを実行
        		ResultSet resultSet = statement.executeQuery();

        		// 結果の処理を行うためのコードをここに追加


        		

        		// ここから先でSQLクエリを実行して結果を処理します


            // SQLクエリを実行
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
				int id = rs.getInt("QUESTION_ID");
				String queTitle = rs.getString("QUESTION_TITLE");
				String queContent = rs.getString("QUESTION_CONTENT");
				
				int userId = rs.getInt("QUESTIONER_ID");
				String userName = rs.getString("QUESTIONER_NAME");
				User user = new User(userId, userName);
				Question question = new Question(id, queTitle, queContent, user);
				questions.add(question);
			}
			return questions;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    // データベース接続をクローズするメソッドを実装することも重要
}

