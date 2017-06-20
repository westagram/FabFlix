package fabflix;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddMovieServlet
 */
@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		String title = request.getParameter("title").trim();
		String year = request.getParameter("year").trim();
		String director = request.getParameter("director").trim();
		String starFirstName = request.getParameter("starFirstName").trim();
		String starLastName = request.getParameter("starLastName").trim();
		String genreName = request.getParameter("genreName").trim();
		
//		System.out.println(title);
//		System.out.println(year);
//		System.out.println(director);
//		System.out.println(starFirstName);
//		System.out.println(starLastName);
//		System.out.println(genreName);
		
		int int_year;
		boolean movieExists;
		
		if (title == "" || year == "" || director == "" || starFirstName == "" || starLastName == "" || genreName == "")
		{
			String missingFieldsError = "Not all required fields were filled out. Please fill out all required fields.";
			request.setAttribute("missingFieldsError", missingFieldsError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/AddMovieFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try
		{
			int_year = Integer.parseInt(year);
		}
		catch (NumberFormatException e)
		{
			String yearError = "Year is not an integer number. Please input an integer number for year field.";
			request.setAttribute("yearError", yearError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/AddMovieFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try
		{
			movieExists = util.addMovie(title, int_year, director, starFirstName, starLastName, genreName);
			request.setAttribute("movieExists", movieExists);
		}
		catch (Exception e)
		{
			String executionError = "Failed to add movie to database. Check connection!";
			request.setAttribute("executionError", executionError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/AddMovieFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/AddMovieSuccessPage.jsp");
		dispatcher.forward(request, response);
	}

}
