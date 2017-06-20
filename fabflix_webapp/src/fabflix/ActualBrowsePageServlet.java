package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActualBrowsePageServlet
 */
@WebServlet("/ActualBrowsePageServlet")
public class ActualBrowsePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualBrowsePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MoviedbUtil util = new MoviedbUtil();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head><link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\"><title>BrowsePage</title><style>#genres td {padding: 0 15px 0 15px;}</style></head>");
		out.println("<input type=\"submit\" value=\"Go to Cart\" class=\"save\" onclick=\"window.location.href='ShoppingCart.jsp'; return false;\"class=\"ShoppingCartervlet\"/>");
		out.println("<input type=\"submit\" value=\"Go to Main\" class=\"save\" onclick=\"window.location.href='MainPage.jsp'; return false;\"/>");
		
		out.println("<body><div id=\"wrapper\"><div id=\"header\"><h2>BROWSE PAGE</h2></div></div>");
		out.println("<div id=\"container\"><h3>Browse By Title</h3>");
		out.println("<table><tbody><tr>");
		
		// Create hyperlinks for movies starting with a number
		for(int i = 0; i < 10; i++)
			out.println("<td><a href=\"BrowsePageServlet?title_option=" + i + "\">" + i + "</a> |</td>");
		
		out.println("</tr><tr>");
		for(int i = 65; i < 91; i++) {
			if(i == 78)
				out.println("<tr>");
			out.println("<td><a href=\"BrowsePageServlet?title_option="+(char)i + "\">"+(char)i+"</a> |</td>");
			if(i == 77)
				out.println("</tr>");
		}
		out.println("</tr></tbody></table><h3>Browse by Genre</h3><table id=\"genres\"><tbody>");
		
		List<Genres> genres = null;
		try {
			genres = util.getGenres();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		int rowCounter = 0;
		for(int i = 0; i < genres.size(); i++) {
			if(rowCounter == 0)
				out.println("<tr>");
			out.println("<td><a href=\"BrowsePageServlet?genresID="+genres.get(i).getId()+"\">"
				+ genres.get(i).getName() + "</a></td>");
			rowCounter++;
			if(rowCounter == 3) {
				out.println("</tr>");
				rowCounter = 0;
			}
			
		}
		
		out.println("</tbody></table></div></body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
