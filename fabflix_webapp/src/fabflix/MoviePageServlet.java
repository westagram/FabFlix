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
 * Servlet implementation class MoviePageServlet
 */
@WebServlet("/MoviePageServlet")
public class MoviePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		int id = Integer.valueOf(request.getParameter("genresID"));
		String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id and genre_id = " + id;
		//System.out.println(sql);
		List<MovieStarGenre> movies = null;
		try {
			movies = util.getMovies(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		/////
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
