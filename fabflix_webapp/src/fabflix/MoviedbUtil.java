package fabflix;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.io.PrintWriter;

//import javax.sql.DataSource;

public class MoviedbUtil
{
	private Connection connection;

	
	public void connectDatabase()
	{
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Properties connectionProps = new Properties();
//			connectionProps.put("user", "root"); // Change db username here
//			connectionProps.put("password", "171389628"); // Change db password here
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
//					+ "moviedb?autoReconnect=true&useSSL=false",
//					connectionProps);
			
			Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");
            connection = ds.getConnection();
		} catch (Exception e) {
		}
	}
	
	public Connection retrieveConnection() // This is a getter for the connection but the name getConnection is already taken
	{
		return this.connection;
	} // made this function just in case, probably won't need it
	
	@SuppressWarnings("null")
	public List<MovieStarGenre> getMovies(String query) throws Exception
	{
		List<MovieStarGenre> movies = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connectDatabase();
			/*
			PreparedStatement pstmt = null;
			String pSql = "ALTER TABLE movies ADD FULLTEXT(title)";
			pstmt = connection.prepareStatement(pSql);
			pstmt.executeUpdate();
			*/
			
			
			stmt = connection.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			int currentMovie = 0;
			MovieStarGenre tempMovie = null;
			int currentStar = 0;
			int currentGenres = 0;
			List<Star> listStars = new ArrayList<Star>();
			List<Genres> listGenres = new ArrayList<Genres>();
			while (rs.next())
			{
				
				int movie_id = rs.getInt("movie_id");
				int star_id = rs.getInt("star_id");
				String title = rs.getString("title");
				int year = rs.getInt("year");
				String director = rs.getString("director");
				String bannerURL = rs.getString("banner_url");
				String trailerURL = rs.getString("trailer_url");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String dob = rs.getString("dob");
				String photoURL = rs.getString("photo_url");
				int genreID = rs.getInt("genre_id");
				String genre = rs.getString("name");
								
				// create new movie object
				Star tempStar = new Star(star_id, firstName, lastName, dob, photoURL);
				Genres tempGenres = new Genres(genreID, genre);
				

				
				if (currentMovie != movie_id)
				{
					if (tempMovie != null)
					{
						//System.out.println("Title: " + title + ", genres: " + listGenres.size() + " stars: " + listStars.size());
						movies.add(tempMovie);
						currentStar = 0;
						currentGenres = 0;
						listStars = new ArrayList<Star>();
						listGenres = new ArrayList<Genres>();
					}
					currentMovie = movie_id;
					tempMovie = new MovieStarGenre(movie_id, title, year, director, bannerURL, trailerURL);
					// add it to the list of movies
					tempMovie.setGenres(listGenres);
					tempMovie.setStars(listStars);
				}
				
				if (currentStar != star_id)
				{
					int sCount = 0;
					for (Star s: listStars)
					{
						if (s.getId() == star_id)
						{
							sCount++;
						}
					}
					if (sCount == 0)
					{
						currentStar = star_id;
						listStars.add(tempStar);
					}
				}
				
				if (currentGenres != genreID)
				{
					int gCount = 0;
					for (Genres g: listGenres)
					{
						if (g.getId() == genreID)
							gCount++;
					}
					if (gCount == 0)
					{
						currentGenres = genreID;
						listGenres.add(tempGenres);
					}
				}
			}
			movies.add(tempMovie);
			return movies;
		}
		finally
		{
			// close JDBC objects
			close(connection, stmt, rs);
			
		}
		
	}

	
	public Star getStar(String query) throws Exception
	{
		//List<Star> stars = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connectDatabase();
			
			stmt = connection.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			
			List<Movie> movies = new ArrayList<Movie>();
			
			Star tempStar = null;
			int count = 0;
			while (rs.next())
			{
				if (count == 0)
				{
					count++;
					int star_id = rs.getInt("star_id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String dob = rs.getString("dob");
					String photoURL = rs.getString("photo_url");
					tempStar = new Star(star_id, firstName, lastName, dob, photoURL);
				}
				
				int movie_id = rs.getInt("movie_id");
				String title = rs.getString("title");
				int year = rs.getInt("year");
				String director = rs.getString("director");
				String bannerURL = rs.getString("banner_url");
				String trailerURL = rs.getString("trailer_url");
				
				int mCount = 0;
				for (Movie movie: movies)
				{
					if (movie.getId() == movie_id)
					{
						mCount++;
					}
				}
				
				if (mCount == 0)
				{
					Movie tempMovie = new Movie(movie_id, title, year, director, bannerURL, trailerURL);
					movies.add(tempMovie);
				}
				
				
			}
			tempStar.setMovies(movies);
			return tempStar;
		}
		finally
		{
			close(connection, stmt, rs);
			
		}
		
	}
	
	
	public MovieStarGenre getMovie(String query) throws Exception
	{
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connectDatabase();
			
			stmt = connection.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			
			List<Star> starsList = new ArrayList<Star>();
			List<Genres> genresList = new ArrayList<Genres>();
			
			MovieStarGenre tempMovie = null;
			int count = 0;
			while (rs.next())
			{
				if (count == 0)
				{
					count++;
					int movie_id = rs.getInt("movie_id");
					String title = rs.getString("title");
					int year = rs.getInt("year");
					String director = rs.getString("director");
					String bannerURL = rs.getString("banner_url");
					String trailerURL = rs.getString("trailer_url");
					tempMovie = new MovieStarGenre(movie_id, title, year, director, bannerURL, trailerURL);
				}
				
				int star_id = rs.getInt("star_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String dob = rs.getString("dob");
				String photoURL = rs.getString("photo_url");
				int genres_id = rs.getInt("genre_id");
				String genresName = rs.getString("name");
				
				int sCount = 0;
				for (Star star: starsList)
				{
					if (star.getId() == star_id)
					{
						sCount++;
					}
				}
				if (sCount == 0)
				{
					Star tempStar = new Star(star_id, firstName, lastName, dob, photoURL);
					starsList.add(tempStar);
				}
				
				int gCount = 0;
				for (Genres genres: genresList)
				{
					if (genres.getId() == genres_id)
					{
						gCount++;
					}
				}
				if (gCount == 0)
				{
					Genres tempGenres = new Genres(genres_id, genresName);
					genresList.add(tempGenres);
				}
				
				
			}
			tempMovie.setStars(starsList);
			tempMovie.setGenres(genresList);
			return tempMovie;
		}
		finally
		{
			close(connection, stmt, rs);
		}
		
	}
	
	public List<Genres> getGenres() throws Exception
	{
		List<Genres> genres = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connectDatabase();
			
			String query = "select * from genres ORDER BY name";
			stmt = connection.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				Genres tempGenre = new Genres(id, name);
				
				genres.add(tempGenre);
			}
			
			return genres;
		}
		finally
		{
			close(connection, stmt, rs);
		}

	}
	
	public void displayMetaData(PrintWriter out) throws Exception
	{
		out.println("<html><head><link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\"><title>Metadata</title><style>#metadata td {padding: 0 15px 0 15px;} caption {font-size: 24px;}</style></head>");
		out.println("<body><div id=\"wrapper\"><div id=\"header\"><h2>Metadata</h2></div></div>");
		out.println("<input type=\"submit\" value=\"Return to Dashboard\" class=\"save\"onclick=\"window.location.href=\'DashboardMainPage.jsp\'; return false;\" class=\"DashBoardServlet\"/><br>");
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSet newRs = null;
		ResultSetMetaData metadata = null;
		
		try
		{
			connectDatabase();
			String query, newQuery;
			query = "show tables";
			stmt = connection.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				
				out.println("<table id=\"metadata\"><caption>" + rs.getString(1) + "</caption><tbody>");
				newQuery = "select * from " + rs.getString(1);
				
				stmt = connection.prepareStatement(newQuery);
				
				newRs = stmt.executeQuery();
				metadata = newRs.getMetaData();
				
				out.println("<tr><th>Attribute Name</th><th>Attribute Type</th></tr>");
				
				for (int i = 1; i <= metadata.getColumnCount(); i++)
				{
					out.println("<tr><td>" + metadata.getColumnName(i) + "</td><td>" + metadata.getColumnTypeName(i) + "</td></tr>");
				}
				out.println("<br></br>");
			}
			
		}
		finally
		{
			close(null, null, newRs);
			close(connection, stmt, rs);
		}
		
		out.println("</table></body></html>");
		out.close();
	}
	
	public void insertStar(String first, String last, java.util.Date date, String photoURL) throws Exception
	{
		Date sqlDate = new Date(date.getTime());
		PreparedStatement stmt = null;
		
		try
		{
			try {
				Context initCtx = new InitialContext();
	            Context envCtx = (Context) initCtx.lookup("java:comp/env");
	            DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDBWrite");
	            connection = ds.getConnection();
			} catch (Exception e) {
			}
			if (photoURL.trim().equals(""))
			{
				String query = "insert into stars(first_name, last_name, dob) values ("
						+ "?,?,?)";
				stmt = connection.prepareStatement(query);
				stmt.setString(1, first);
				stmt.setString(2, last);
				stmt.setDate(3, sqlDate);
				stmt.executeUpdate();
			}
			else
			{
				String query = "insert into stars(first_name, last_name, dob, photo_url) values ("
						+  "?,?,?,?)";
				stmt = connection.prepareStatement(query);
				stmt.setString(1, first);
				stmt.setString(2, last);
				stmt.setDate(3, sqlDate);
				stmt.setString(4, photoURL);
				stmt.executeUpdate();
			}
		}
		finally
		{
			close(connection, stmt, null);
		}
	}
	
	public boolean addMovie(String title, int year, String director, String starFirstName, String starLastName, String genreName) throws Exception
	{
		CallableStatement stmt = null;
		
		try
		{
			try {
				Context initCtx = new InitialContext();
	            Context envCtx = (Context) initCtx.lookup("java:comp/env");
	            DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDBWrite");
	            connection = ds.getConnection();
			} catch (Exception e) {
			}
			
			String procedure = "{call add_movie(?,?,?,?,?,?,?)}";
			
			stmt = connection.prepareCall(procedure);
			stmt.setString(1, title);
			stmt.setInt(2, year);
			stmt.setString(3, director);
			stmt.setString(4, starFirstName);
			stmt.setString(5, starLastName);
			stmt.setString(6, genreName);
			stmt.registerOutParameter(7, java.sql.Types.BOOLEAN);
			stmt.execute();
			
			boolean movieExists = stmt.getBoolean(7);
			return movieExists;
		}
		finally
		{
			close(connection, stmt, null);
		}
	}
	
	
	private void close(Connection conn, PreparedStatement stmt, ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
			
			if (stmt != null)
			{
				stmt.close();
			}
			
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (Exception e)
		{
		}
		
	}

}
