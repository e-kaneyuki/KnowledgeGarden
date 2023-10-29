package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnswerLogic;
import model.AnswerRegistration;
import model.Question;
import model.QuestionLogic;

/**
 * Servlet implementation class CreateAnswer
 */
@WebServlet("/CreateAnswer")
public class CreateAnswerServlet extends HttpServlet {
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
		
        int id = Integer.parseInt(request.getParameter("questionId"));

        
        QuestionLogic queLog = new QuestionLogic();
        Question question = queLog.showQuestion(id);
        
        request.setAttribute("question", question);
        
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createAnswer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("utf-8");
		
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		
		//セッションスコープを作成
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		
		//文字化け対策した上で変数セット
        String content = request.getParameter("answerContent");
		
        AnswerLogic logic = new AnswerLogic();
        AnswerRegistration ansRegist = new AnswerRegistration(content, userID, questionId);
		boolean judge = logic.execute(ansRegist);
		
		if (judge) {
			String id = request.getParameter("questionId");			
			response.sendRedirect("ShowQuestion?id="+id);
	        //ここで次のサーブレットへリダイレクト
//	        response.sendRedirect("IndexQuestion");
		}
	}
}
