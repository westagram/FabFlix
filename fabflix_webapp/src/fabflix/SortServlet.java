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
 * Servlet implementation class SortServlet
 */
@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
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
		
		String sortOption = request.getParameter("sorting_order");
		
		MoviedbUtil util = new MoviedbUtil();
		String sql = (String) session.getAttribute("SQL");
		
		
		if (sortOption.equals("AtoZ"))
		{
			sql += " order by movies.title";
		}
		else if (sortOption.equals("ZtoA"))
		{
			sql += " order by movies.title desc";
		}
		else if (sortOption.equals("OldestToNewest"))
		{
			sql += " order by movies.year";
		}
		else
		{
			sql += " order by movies.year desc";
		}
		
		
		List<MovieStarGenre> movies = null;
		
		try
		{
			movies = util.getMovies(sql);
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
		
		
		request.setAttribute("MOVIE_LIST", movies);
		List<MovieStarGenre> tempMovies = new ArrayList<MovieStarGenre>();
		
		if (movies.size()>10)
		{
			for (int i = 0; i<10;i++)
			{
				tempMovies.add(movies.get(i));
			}
		}
		else
		{
			for (int i = 0; i<movies.size();i++)
			{
				tempMovies.add(movies.get(i));
			}
		}
		
		session.setAttribute("MOVIE_LIST", movies);
		session.setAttribute("mPerPage", 10);
		session.setAttribute("movieSize", movies.size());
		request.setAttribute("movie_list", tempMovies);
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/MoviePage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
