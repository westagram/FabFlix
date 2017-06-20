package fabflix;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertNewStarServlet
 */
@WebServlet("/InsertNewStarServlet")
public class InsertNewStarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewStarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviedbUtil util = new MoviedbUtil();
		HttpSession session = request.getSession(false);

		if (session == null)
		{
			session = request.getSession(true);
		}
		
		String name = request.getParameter("name").trim();
		String dateString = request.getParameter("dob").trim();
		String photoURL = request.getParameter("photoURL").trim();
		
		String first = null;
		String last = null;
		java.util.Date date = null;
		DateFormat dateFormat = null;
		
		if (name == "")
		{
			String noNameError = "There must be at least one name!";
			session.setAttribute("noNameError", noNameError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertNewStarFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		String[] fullName = name.split(" ");
		if (fullName.length == 1)
		{
			first = "";
			last = fullName[0];
		}
		else if (fullName.length == 2)
		{
			first = fullName[0];
			last = fullName[1];
		}
		else
		{
			String nameError = "There can only be two names (first and last)!";
			session.setAttribute("nameError", nameError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertNewStarFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try
		{
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			String dateError = "Invalid date format (MM/DD/YYYY)!";
			session.setAttribute("dateError", dateError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertNewStarFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
			
		try
		{
			util.insertStar(first, last, date, photoURL);
		}
		catch (Exception e)
		{
			String executionError = "Failed to add star to database. Check connection!";
			request.setAttribute("executionError", executionError);
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertNewStarFailPage.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertNewStarSuccessPage.jsp");
		dispatcher.forward(request, response);
	}

}
