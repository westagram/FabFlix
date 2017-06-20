package fabflix;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SingleStarServlet
 */
@WebServlet("/SingleStarServlet")
public class SingleStarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleStarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		
		int id = Integer.valueOf(request.getParameter("starID"));
		String sql = "select * from movies join stars_in_movies join stars where stars.id = star_id and movies.id = movie_id and star_id = " + id; 
		//System.out.println(sql);
		Star star = null;
		try {
			star = util.getStar(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		request.setAttribute("STAR", star);
		request.setAttribute("photoURL", star.getPhotoURL());
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/SingleStarPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
