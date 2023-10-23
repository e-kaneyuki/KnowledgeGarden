package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuestionLogic;
import model.QuestionRegistration;
/**
 * Servlet implementation class CreateQuestionServlet
 */
@WebServlet("/CreateQuestion")
public class CreateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createQuestion.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		//文字化け対策
		request.setCharacterEncoding("utf-8");
		//文字化け対策した上で変数セット
		String title = request.getParameter("questionTitle");
        String content = request.getParameter("questionContent");
		
        QuestionLogic logic = new QuestionLogic();
        QuestionRegistration queRegist = new QuestionRegistration(title, content, userID);
		boolean judge = logic.execute(queRegist);
		
		if (judge) {
			
	        //ここで次のサーブレットへリダイレクト
	        response.sendRedirect("QuestionIndex");
	        
		}
	}

}
