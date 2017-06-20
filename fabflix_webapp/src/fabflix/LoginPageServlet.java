package fabflix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.net.ssl.HttpsURLConnection;

@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection myConn;
    public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public static boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            return false;
        }

        try {
            URL verifyUrl = new URL(SITE_VERIFY_URL);
            
            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();

            // Add Request Header
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
 
            // Data will be sent to the server.
            String postParams = "secret=" + "6LcshyAUAAAAAPuULxcqvRPOPISzYDNoXmoAxkxi" + "&response=" + gRecaptchaResponse;
 
            // Send Request
            conn.setDoOutput(true);
            
            // Get the output stream of Connection
            // Write data in this stream, which means to send data to Server.
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
 
            outStream.flush();
            outStream.close();
 
            // Response code return from server.
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode=" + responseCode);
 
  
            // Get the InputStream from Connection to read data sent from the server.
            InputStream is = conn.getInputStream();
 
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
 
            // ==> {"success": true}
            System.out.println("Response: " + jsonObject);
 
            boolean success = jsonObject.getBoolean("success");
            System.out.println("Passed success");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
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
			out.print("true");
			out.flush();
		}
		else
		{
			out.print("false");
			out.flush();
		}
		out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);

        boolean valid = verify(gRecaptchaResponse);
        if (!valid) {
        	response.sendRedirect("LoginFail.jsp");
        	return;
        }

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
			session.setAttribute("customerID", getID(email, password));
			response.sendRedirect("MainPage.jsp");
		}
		else
		{
			response.sendRedirect("LoginFail.jsp");
		}
	}
	
	public int checkLogin(String email, String password)
	{	
		int check = 0;
		try {
			String sql = "select * from customers where email = '" + email +
					"' and password = '" + password + "'";
			PreparedStatement myStmt = myConn.prepareStatement(sql);
			
			ResultSet myRs = myStmt.executeQuery();
			if(myRs.next())
				check++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return check;
	}
	
	public int getID(String email, String password)
	{	
		int result = 0;
		try {
			String sql = "select * from customers where email = '" + email +
					"' and password = '" + password + "'";
			PreparedStatement myStmt = myConn.prepareStatement(sql);
			
			ResultSet myRs = myStmt.executeQuery();
			while (myRs.next())
				result = myRs.getInt("id"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return result;
	}
}
