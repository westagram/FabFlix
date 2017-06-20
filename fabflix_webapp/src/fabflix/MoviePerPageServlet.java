package fabflix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MoviePerPageServlet
 */
@WebServlet("/MoviePerPageServlet")
public class MoviePerPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviePerPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		int mPerPage = Integer.valueOf(request.getParameter("perPage"));
		int nPage = Integer.valueOf(request.getParameter("page"));
		session.setAttribute("mPerPage", mPerPage);
		List<MovieStarGenre> movies = (List<MovieStarGenre>) session.getAttribute("MOVIE_LIST");
		List<MovieStarGenre> tempMovies = new ArrayList<MovieStarGenre>();

		if (movies.size() < mPerPage)
		{
			for (int i = ((nPage-1)*mPerPage); i<movies.size();i++)
			{
				tempMovies.add(movies.get(i));
			}
		}
		
		else if(nPage*mPerPage > movies.size())
		{
			for (int i = ((nPage-1)*mPerPage); i<movies.size();i++)
			{
				tempMovies.add(movies.get(i));
			}
		}
		else
		{
			for (int i = ((nPage-1)*mPerPage); i<(nPage*mPerPage);i++)
			{
				tempMovies.add(movies.get(i));
			}
		}
		
		request.setAttribute("movie_list", tempMovies);
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/MoviePage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
