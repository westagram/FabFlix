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
 * Servlet implementation class CartUpdateServlet
 */
@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int id;
    private String command;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.valueOf(request.getParameter("movieID"));
		command = request.getParameter("command");
		if (command.equals("UPDATE"))
			response.sendRedirect("UpdateMovie.jsp");
		else if(command.equals("DELETE"))
		{
			MoviedbUtil util = new MoviedbUtil();
			HttpSession session = request.getSession(false);

			if (session == null)
			{
				session = request.getSession(true);
			}
			
			String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id and movies.id = " + id;
			
			MovieStarGenre tempMovie = null;
			
			try {
				tempMovie = util.getMovie(sql);
			} catch (Exception e) {
			}
			
			List<ArrayList<MovieStarGenre>> movies = new ArrayList<ArrayList<MovieStarGenre>>();
			movies = (List<ArrayList<MovieStarGenre>>) session.getAttribute("movieList");
			
			for (int i = 0; i<movies.size(); i++)
			{
				if (movies.get(i).get(0).getMovie_id() == id)
				{
					movies.remove(i);
					break;
				}
			}
			
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/ShoppingCart.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MoviedbUtil util = new MoviedbUtil();
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		
		String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id and movies.id = " + id;
		
		MovieStarGenre tempMovie = null;
		
		try {
			tempMovie = util.getMovie(sql);
		} catch (Exception e) {
		}
		
		List<ArrayList<MovieStarGenre>> movies = new ArrayList<ArrayList<MovieStarGenre>>();
		movies = (List<ArrayList<MovieStarGenre>>) session.getAttribute("movieList");
		if (command.equals("UPDATE"))
		{
			
			int update = Integer.valueOf(request.getParameter("UPDATE"));
			
			for (int i = 0; i<movies.size(); i++)
			{
				if (movies.get(i).get(0).getMovie_id() == id)
				{
					movies.get(i).clear();
					if(update == 0)
					{
						movies.remove(i);
						break;
					}
					else
					{
						for (int y = 0 ; y<update; y++)
						{
							movies.get(i).add(tempMovie);
						}
					}
				}
			}
		}
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/ShoppingCart.jsp");
		dispatcher.forward(request, response);
	}

}
