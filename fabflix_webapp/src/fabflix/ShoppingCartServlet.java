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
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
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
		
		if (request.getParameter("movieID").trim().equals(""))
		{
			response.sendRedirect("ShoppingCart.jsp");
		}
		else
		{
			
			int id = Integer.valueOf(request.getParameter("movieID"));
			List<ArrayList<MovieStarGenre>> movies = new ArrayList<ArrayList<MovieStarGenre>>();
			
			
			String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id and movies.id = " + id;
			
			MovieStarGenre tempMovie = null;
			
			try {
				tempMovie = util.getMovie(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			ArrayList<MovieStarGenre> tempArrayMovie = new ArrayList<MovieStarGenre>();
			if (session.getAttribute("movieList") == null)
			{
				tempArrayMovie.add(tempMovie);
				movies.add(tempArrayMovie);
				//session.setAttribute("movieList", movies);
			}
			else
			{
				//System.out.println("Movie Size: " + movies.size());
	
				movies = (List<ArrayList<MovieStarGenre>>) session.getAttribute("movieList");
				int count = 0;
				for (ArrayList<MovieStarGenre> i: movies)
				{
					if (i.get(0).getMovie_id() == id)
					{
						count++;
						i.add(tempMovie);
						break;
					}
				}
				if (count == 0)
				{
					tempArrayMovie.add(tempMovie);
					movies.add(tempArrayMovie);
				}
				
			}
			session.setAttribute("movieList", movies);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/ShoppingCart.jsp");
			dispatcher.forward(request, response);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
