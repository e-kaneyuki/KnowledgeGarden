package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Registration;
import model.RegistrationLogic;

/**
 * Servlet implementation class UserRegisatrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("utf-8");
		//文字化け対策した上で変数セット
		int userID = Integer.parseInt(request.getParameter("userID"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //BOクラスでDAOクラスでDBへinsertできたかをjudgeする。
		RegistrationLogic regiLogic = new RegistrationLogic();
		Registration reg = new Registration(userID, userName, password);
		boolean judge = regiLogic.execute(reg);
		
		//もしINSERTできていたらsessionスコープを作成し質問投稿画面へ遷移
		if (judge) {
			HttpSession session = request.getSession();
	        session.setAttribute("userID", userID);
	        session.setAttribute("userName", userName);
	        session.setAttribute("password", password);
	        
	        //ここで次のサーブレットへリダイレクト
	        response.sendRedirect("QuestionIndex");
	        
		}
		//もし登録に失敗した場合はどうするのか	
	    
		
        
		
	}

}
