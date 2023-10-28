package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;
import model.Question;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//文字化け対策した上で変数セット
		
//		String questionTitle = request.getParameter("questionTitle");
//        String questionContent = request.getParameter("questionContent");
//        String questioner = request.getParameter("questioner");
//        String answerContent = request.getParameter("answerContent");
        
//        SearchLogic logic = new SearchLogic();
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//文字化け対策した上で変数セット
		String questionTitle  = request.getParameter("searchTerm");
		SearchDAO dao = new SearchDAO();
        
        List<Question> logic = dao.searchQuestions(questionTitle);
        for(Question logics: logic) {
        	System.out.println(logics.getTitle());
        }
        request.setAttribute("questions", logic);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/indexQuestion.jsp");
		dispatcher.forward(request, response);
	}



}
