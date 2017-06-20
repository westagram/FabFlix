<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- </%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>

<html>

<head>	
	<title>Movie Information</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<input type="submit" value="Go to Cart" class="save"
					onclick="window.location.href='ShoppingCart.jsp'; return false;"
					class="ShoppingCartervlet"/>
<input type="submit" value="Go to Main" class="save"
					onclick="window.location.href='MainPage.jsp'; return false;"/>	

<body>

	<div id="wrapper">
		<div id="header">
			<h2>MOVIE INFORMATION</h2>
		</div>
	</div>

	<div id="container">
		
		
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="submit" value="Return to Searching" class="save"
					onclick="window.location.href='SearchPage.jsp'; return false;"
					class="SearchPageServlet"/>
			
			<input type="submit" value="Return to Browsing" class="save"
					onclick="window.location.href='ActualBrowsePageServlet'; return false;"
					class="BrowsePageServlet"/>
			
			<table>
			
				<tr>
					<th>Movie ID</th>
					<th>Title</th>
					<th>Year</th>
					<th>Genres</th>
					<th>Poster</th>
					<th>Stars</th>
					<th>Trailer URL</th>
					<th>Add to Cart</th>
					
				</tr>
				
				<tr>
					<td> ${MOVIE.movie_id} </td>
					<td> ${MOVIE.title} </td>
					<td> ${MOVIE.year}</td>
					<td> 
						<table>
							<c:forEach var = "genres" items = "${MOVIE.genres}">
			
							<tr><td><a href = "MoviePageServlet?genresID=${genres.id}">	${genres.name} <br/> </a></td></tr>
						
							</c:forEach>
						</table>
					</td>
					<td> <img src=<%= request.getAttribute("bannerURL") %> style="width:120px;height:150px;"></td>
					<td> 
						<table>
							<c:forEach var = "star" items = "${MOVIE.stars}">
			
							<tr><td><a href = "SingleStarServlet?starID=${star.id}">	${star.fullName} <br/> </a></td></tr>
						
							</c:forEach>
						</table>
					</td>
					<td> ${MOVIE.trailerURL}</td>
					<td><a href="ShoppingCartServlet?movieID=${MOVIE.movie_id}" onclick="if (!(confirm('Add to cart?'))) return false">Add to Cart</a></td>
					
					
				</tr>
				
				
			</table>
		
		</div>
	
	</div>
</body>


</html>
