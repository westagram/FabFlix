package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MetadataServlet
 */
@WebServlet("/MetadataServlet")
public class MetadataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MetadataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			util.displayMetaData(out);
		}
		catch (Exception e)
		{
			out.println("<html><head><link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\"><title>Metadata</title></head>");
			out.println("<body><div id=\"wrapper\"><div id=\"header\"><h2>Metadata</h2></div></div>");
			out.println("<div id=\"container\">Error: Unable to retrieve metadata. Check connection! Click <input type=\"submit\" value=\"here\" onclick=\"window.location.href='DashboardMainPage.jsp'; return false;\"/>to return to dashboard!</div>");
			out.println("</body></html>");
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
