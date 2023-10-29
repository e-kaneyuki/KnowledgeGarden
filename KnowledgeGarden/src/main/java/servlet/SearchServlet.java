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

import dao.SearchDAO;
import model.Question;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("userName");
		if (user == null) {
			String message = "ログインしてください。";
			session.setAttribute("loginMessage", message);
			response.sendRedirect("Login");
			return;
		}
     
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//文字化け対策した上で変数セット
		String questionTitle  = request.getParameter("searchTerm");
		SearchDAO dao = new SearchDAO();
        
        List<Question> logic = dao.searchQuestions(questionTitle);

        request.setAttribute("questions", logic);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/indexQuestion.jsp");
		dispatcher.forward(request, response);
	}
}
