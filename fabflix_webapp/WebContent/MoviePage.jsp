<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- </%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>

<html>

<head>	
	<title>Movie Page</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<input type="submit" value="Go to Cart" class="save"
					onclick="window.location.href='ShoppingCart.jsp'; return false;"
					class="ShoppingCartervlet"/>
<input type="submit" value="Go to Main" class="save"
					onclick="window.location.href='MainPage.jsp'; return false;"/>	

<%
	// get the students from the request object (sent by servlet)
	//MoviedbUtil util = new MoviedbUtil();
	//List<Movie> movies = util.getMovies("select * from movies");
%>


<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="PopupWindow.js"></script>
	
	<div id="wrapper">
		<div id="header">
			<h2>MOVIE LIST</h2>
		</div>
	</div>
	
	<c:url var="addToCart" value="ShoppingCartServlet">
		<c:param name="command" value="LOAD"/>
	</c:url>

	<div id="container">
	
		<div id="content">

			<input type="submit" value="Return to Searching" class="save"
					onclick="window.location.href='SearchPage.jsp'; return false;"
					class="SearchPageServlet"/>
			
			<input type="submit" value="Return to Browsing" class="save"
					onclick="window.location.href='ActualBrowsePageServlet'; return false;"
					class="BrowsePageServlet"/>
			
			Movie(s) Per Page: 
						
			<a href="MoviePerPageServlet?perPage=10&page=1">10</a>
			<a href="MoviePerPageServlet?perPage=25&page=1">25</a>
			<a href="MoviePerPageServlet?perPage=50&page=1">50</a>
			<a href="MoviePerPageServlet?perPage=100&page=1">100</a>
			
			
			<table>
				<tr>
					<td>Sort by:</td>
					<td><a href="SortServlet?sorting_order=AtoZ">A-Z</a> |</td>
					<td><a href="SortServlet?sorting_order=ZtoA">Z-A</a> |</td>
					<td><a href="SortServlet?sorting_order=OldestToNewest">Oldest-Newest</a> |</td>
					<td><a href="SortServlet?sorting_order=NewestToOldest">Newest-Oldest</a> |</td>
				</tr>
			</table>
			
			
			<p>Page 
			
			<% for (int i = 1; i<((int)((int)session.getAttribute("movieSize")/(int)session.getAttribute("mPerPage"))+2); i++){%>
				<a href="MoviePerPageServlet?perPage=<%=session.getAttribute("mPerPage")%>&page=<%=i%>"><%=i%></a>
			<% }%>
			</p>
			<table>
			
				<tr>
					<th>Movie ID</th>
					<th>Title</th>
					<th>Year</th>
					<th>Director</th>
					<th>Genres</th>
					<th>Stars</th>
					<th>Add to Cart</th>
					
				</tr>
				
				<c:forEach var = "m" items = "${movie_list}"> 
				
					<tr>
						<td> ${m.movie_id} </td>
						
						<td> 
						
						 
						<div>
						<h3 class="enter" id="${m.movie_id}"> <a href = "SingleMovieServlet?movieID=${m.movie_id}"> ${m.title}</a></h3>
						</div> 
						
						
						<!-- 
						<a href = "SingleMovieServlet?movieID=${m.movie_id}"> 
						<div class="tooltip">${m.title}
  						<span class="tooltiptext">${m.title}
  						</span></div>
  						
						</a>  --></td>
						
						
						<td> ${m.year}</td>
						<td> ${m.director} </td>
						<td> 
							<table>
								<c:forEach var = "g" items = "${m.genres}">
				
								<tr><td>${g.name}</td></tr>
							
								</c:forEach>
							</table>
						</td>
						<td> 
							<table>
								
								<c:forEach var = "s" items = "${m.stars}"> 
								<a href = "SingleStarServlet?starID=${s.id}">	${s.fullName} <br/> </a>
								</c:forEach>
								
							</table>
						</td>
						
						<td><a href="ShoppingCartServlet?movieID=${m.movie_id}" onclick="if (!(confirm('Add to cart?'))) return false">Add to Cart</a></td>
						
						
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>
