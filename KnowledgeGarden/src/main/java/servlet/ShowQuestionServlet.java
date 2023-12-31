package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("userName");
		if (user == null) {
			String message = "ログインしてください。";
			session.setAttribute("loginMessage", message);
			response.sendRedirect("Login");
			return;
		}
		
		// パラメータ "id" を取得
        int id = Integer.parseInt(request.getParameter("id"));
        List<Answer> ansList = null;
        
        QuestionLogic queLog = new QuestionLogic();
        Question question = queLog.showQuestion(id);
        request.setAttribute("question", question);
        
        AnswerLogic ansLog = new AnswerLogic();
        ansList = ansLog.findAnswerById(id);
        if(ansList != null) {
        	request.setAttribute("ansList", ansList);	
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/showQuestion.jsp");
		dispatcher.forward(request, response);
	}
}
