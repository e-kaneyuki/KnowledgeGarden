package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import model.QuestionLogic;

/**
 * Servlet implementation class QuestionIndexServlet
 */
@WebServlet("/IndexQuestion")
public class IndexQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionLogic queLogic = new QuestionLogic();
		List<Question> questions = queLogic.execute();
		request.setAttribute("questions", questions);
		
//		for (Question question: questions) {
//			System.out.println(question.getUser());
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/indexQuestion.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
