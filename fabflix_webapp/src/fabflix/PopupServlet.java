package fabflix;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopupServlet
 */
@WebServlet("/PopupServlet")
public class PopupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		MoviedbUtil util = new MoviedbUtil();
		
		String movie_id = request.getParameter("movieid");
		String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id and movies.id = " + movie_id;
		
		
		List<MovieStarGenre> movies = null;
		try {
			movies = util.getMovies(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		MovieStarGenre movie = movies.get(0);
		request.setAttribute("movie", movie);
		
	    request.getRequestDispatcher("MoviePopup.jsp").forward(request, response);
	    response.getWriter().write(response.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
