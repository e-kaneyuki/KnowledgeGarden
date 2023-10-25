package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Answer;
import model.AnswerLogic;
import model.Question;
import model.QuestionLogic;

/**
 * Servlet implementation class ShowQuestion
 */
@WebServlet("/ShowQuestion")
public class ShowQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータ "id" を取得
        int id = Integer.parseInt(request.getParameter("id"));
        List<Answer> ansList = null;
        
        QuestionLogic queLog = new QuestionLogic();
        Question question = queLog.showQuestion(id);
        request.setAttribute("question", question);
        
        AnswerLogic ansLog = new AnswerLogic();
        ansList = ansLog.findAnswerById(id);
        for(Answer ans: ansList) {
        	System.out.println(ans.getContent());
        }
        if(ansList != null) {
        	request.setAttribute("ansList", ansList);	
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/showQuestion.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
