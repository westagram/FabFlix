package fabflix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection myConn;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		List<ArrayList<MovieStarGenre>> movies = new ArrayList<ArrayList<MovieStarGenre>>();
		movies = (List<ArrayList<MovieStarGenre>>) session.getAttribute("movieList");
		
		
		if (movies == null)
			response.sendRedirect("EmptyCart.jsp");
		else
		{
			if (movies.size() == 0)
				response.sendRedirect("EmptyCart.jsp");
			else
				response.sendRedirect("CheckOutPage.jsp");
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Properties connectionProps = new Properties();
//			connectionProps.put("user", "root"); // Change db username here
//			connectionProps.put("password", "171389628"); // Change db password here
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
//					+ "moviedb?autoReconnect=true&useSSL=false",
//					connectionProps);
			
			Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDBWrite");
            myConn = ds.getConnection();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		String ccid = request.getParameter("ccid");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String date = request.getParameter("date");
		
		
		int check = checkLogin(ccid, firstName, lastName, year, month, date);
		
		if(check > 0)
		{

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date currentTime = new Date();
			String strDate = dateFormat.format(currentTime);
			
			
			HttpSession session = request.getSession(false);

			if (session == null)
			{
				session = request.getSession(true);
			}
			String customerID = Integer.toString((int) session.getAttribute("customerID"));
			List<ArrayList<MovieStarGenre>> movies = new ArrayList<ArrayList<MovieStarGenre>>();
			movies = (List<ArrayList<MovieStarGenre>>) session.getAttribute("movieList");
			
			for (ArrayList<MovieStarGenre> m: movies)
			{
				for(MovieStarGenre msg: m)
				{
					try {
						String sql = "insert into sales(customer_id, movie_id, sale_date) values('" + customerID + "', '"+ 
								msg.getMovie_id() + "', '" + strDate + "')";
						PreparedStatement myStmt = myConn.prepareStatement(sql);
//						String sql = "insert into sales(customer_id, movie_id, sale_date) values('" + customerID + "', '"+ 
//								msg.getMovie_id() + "', '" + strDate + "')";
						myStmt.executeUpdate();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					}
				}
			}
			movies.clear();
			session.setAttribute("movieList", movies);
			response.sendRedirect("ConfirmationPage.jsp");
		}
		else
		{
			response.sendRedirect("CheckOutError.jsp");
		}
	}
	
	public int checkLogin(String ccid, String first, String last, String year, String month, String date)
	{	
		int check = 0;
		try {
			String sql = "select * from creditcards where id = '" + ccid +
					"' and first_name = '" + first + "' and last_name = '" + last +
					"' and expiration = '" + year + "-" + month + "-" + date + "'";
			PreparedStatement myStmt = myConn.prepareStatement(sql);
			
			ResultSet myRs = myStmt.executeQuery();
			if(myRs.next())
				check++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return check;
	}
}
