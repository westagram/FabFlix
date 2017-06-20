package fabflix;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SingleMovieServlet
 */
@WebServlet("/SingleMovieServlet")
public class SingleMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		
		int id = Integer.valueOf(request.getParameter("movieID"));
		String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id and movies.id = " + id;
		MovieStarGenre movie = null;
		try {
			movie = util.getMovie(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		request.setAttribute("MOVIE", movie);
		request.setAttribute("bannerURL", movie.getBannerURL());
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/SingleMoviePage.jsp");
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
