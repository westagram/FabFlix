package fabflix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchPageServlet
 */
@WebServlet("/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		MoviedbUtil util = new MoviedbUtil();
		
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		String input = null;
		
		input = request.getParameter("search");
		String option = request.getParameter("searchOption");
		
		String sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id "
					 +"and " + option + " like '%" + input + "%'";
		
		List<MovieStarGenre> movies = null;
		try {
			movies = util.getMovies(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		if(movies.get(0) == null)
			out.print("");
		else {
			String movieTitles = "";
			for(int i = 0; i < movies.size(); i++) {
				movieTitles += movies.get(i).getTitle();
				movieTitles += "|";
			}
			out.print(movieTitles);
		}
		
		out.flush();
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CALCULATING TS
		// Time an event in a program to nanosecond precision
		long TSstartTime = System.nanoTime();
		
		MoviedbUtil util = new MoviedbUtil();
		
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		String sql = "";
		String input = request.getParameter("search");
		String option = request.getParameter("searchOption");

		
		if (option.equals("full_name"))
		{
			String[] full = input.split(" ");
			if(input.trim().equals(""))
			{
				sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id";
			}
			else if (full.length == 1)
			{
				sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id ";
				sql += "and first_name like '%" + full[0] + "%' or last_name like '%" + full[0] + "%'";
			}
			else
			{
				sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id ";
				sql += "and first_name like '%" + full[0] + "%' and last_name like '%" + full[1] + "%'";
			}
			
		}
		else
		{
			sql = "select * from movies join stars_in_movies join stars join genres_in_movies join genres where stars_in_movies.star_id = stars.id and stars_in_movies.movie_id = movies.id and genres_in_movies.genre_id = genres.id and genres_in_movies.movie_id = movies.id ";
			sql += "and " + option + " like '%" + input + "%'";
		}
		
				
		List<MovieStarGenre> movies = null;
		long TJstartTime = System.nanoTime();
		try {
			movies = util.getMovies(sql);
		} catch (Exception e) {}
		long TJendTime = System.nanoTime();
		
		
		
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
		
		// END CALCULATING TS
		long TSendTime = System.nanoTime();
		long TSelapsedTime = TSendTime - TSstartTime; // elapsed time in nano seconds. Note: print the values in nano seconds 
		long TJelapsedTime = TJendTime - TJstartTime;
		try{
			
			File logFile = new File("/home/ubuntu/tomcat/bin/log.txt");

			FileWriter fileWriter = new FileWriter(logFile, true);
			BufferedWriter buffer = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(buffer);
			
			printWriter.println("JDBCTimeElapsed:" + TJelapsedTime);
			printWriter.println("ServletTimeElapsed:" + TSelapsedTime);
			printWriter.close();
			
			
		} catch (IOException e) {
		   // do something
		}
		
	}

}
