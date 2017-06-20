package fabflix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection myConn;  
    
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("_dashboard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Properties connectionProps = new Properties();
//			connectionProps.put("user", "root"); // Change db username here
//			connectionProps.put("password", "RhGtWCBA2016sql"); // Change db password here
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
//					+ "moviedb?autoReconnect=true&useSSL=false",
//					connectionProps);
			
			Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");
            myConn = ds.getConnection();
		} catch (Exception e) {
		}
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		int check = checkLogin(email, password);
		
		if(check > 0)
		{
			response.sendRedirect("DashboardMainPage.jsp");
		}
		else
		{
			response.sendRedirect("DashboardLoginFail.jsp");
		}
	}

	private int checkLogin(String email, String password) {
		int check = 0;
		try {
			String sql = "select * from employees where email = '" + email +
					"' and password = '" + password + "'";
			PreparedStatement myStmt = myConn.prepareStatement(sql);
//			String sql = "select * from employees where email = '" + email +
//					"' and password = '" + password + "'";
			ResultSet myRs = myStmt.executeQuery();
			if(myRs.next())
				check++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return check;
	}

}
