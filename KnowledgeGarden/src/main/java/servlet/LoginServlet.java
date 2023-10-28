package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserLogic;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userID"));
        String password = request.getParameter("password");
        
        UserLogic userLog = new UserLogic();
        User user = userLog.login(userId, password);

        if (user != null) {
            // 認証成功
            HttpSession session = request.getSession();
	        session.setAttribute("userID", user.getId());
	        session.setAttribute("userName", user.getName());
	        session.setAttribute("password", user.getPass());

            response.sendRedirect("IndexQuestion"); // ログイン後のページにリダイレクト
        } else {
            // 認証失敗
            request.setAttribute("message", "ユーザー名またはパスワードが正しくありません。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
        
	}

}
