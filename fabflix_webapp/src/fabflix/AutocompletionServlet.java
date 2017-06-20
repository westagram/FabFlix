package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AutocompletionServlet
 */
@WebServlet("/AutocompletionServlet")
public class AutocompletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutocompletionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		
		String search = request.getParameter("search");
//		System.out.println(search);
		if (search.equals(""))
		{
			response.getWriter().write("");
		}
		else
		{
//			String sql = "ALTER TABLE movies ADD FULLTEXT(title);";
			String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id ";
			sql += "and MATCH (title) AGAINST ('";
			
			String[] keywords = search.split(" ");
			for (int i = 0; i<keywords.length; i++)
			{
				sql+= "+" + keywords[i] + "* ";
			}
			
			sql += "' IN BOOLEAN MODE)";
		
			//System.out.println(sql);
			
			List<MovieStarGenre> movies = null;
			try {
				movies = util.getMovies(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			if (movies.size() == 0)
			{
				response.getWriter().write("");
			}
			else
			{
				//MovieStarGenre movie = movies.get(0);
				//System.out.println(movie.getTitle());
				request.setAttribute("movies", movies);
		
			    response.setContentType("text/html");
			    request.getRequestDispatcher("Autocompletion.jsp").forward(request, response);
			    response.getWriter().write(response.toString());
			}
		}
		
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String title = request.getParameter("input");
		
		if (title.trim().equals(""))
		{
			response.sendRedirect("MainPage.jsp");
		}
		
		
		else
		{
			MoviedbUtil util = new MoviedbUtil();
			
			HttpSession session = request.getSession(false);
	
			if (session == null)
			{
				session = request.getSession(true);
			}
			
	//		String sql = "ALTER TABLE movies ADD FULLTEXT(title);";
			String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id ";
			sql += "and MATCH (title) AGAINST ('";
			
			String[] keywords = title.split(" ");
			for (int i = 0; i<keywords.length; i++)
			{
				sql+= "+" + keywords[i] + "* ";
			}
			
			sql += "' IN BOOLEAN MODE)";
		
			//System.out.println(sql);
			
			List<MovieStarGenre> movies = null;
			try {
				movies = util.getMovies(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
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
			
			session.setAttribute("SQL", sql);
			session.setAttribute("MOVIE_LIST", movies);
			session.setAttribute("mPerPage", 10);
			session.setAttribute("movieSize", movies.size());
			request.setAttribute("movie_list", tempMovies);
			
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/MoviePage.jsp");
			dispatcher.forward(request, response);
		}
//		System.out.println(title);
//		response.sendRedirect("LoginFail.jsp");
	}

}
