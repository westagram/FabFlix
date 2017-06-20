<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- </%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>

<html>

<head>	
	<title>Star Information</title>
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
			<h2>STAR INFORMATION</h2>
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
					<th>Star ID</th>
					<th>Name</th>
					<th>Date of Birth</th>
					<th>PhotoURL</th>
					<th>Movies</th>
					
				</tr>
				
				<tr>
					<td> ${STAR.id} </td>
					<td> ${STAR.fullName} </td>
					<td> ${STAR.dob}</td>
					<td> <img src=<%= request.getAttribute("photoURL") %> style="width:120px;height:150px;"></td>
					<td> 
						<table>
							<c:forEach var = "movie" items = "${STAR.movies}">
			
							<tr><td><a href = "SingleMovieServlet?movieID=${movie.id}">	${movie.title} <br/> </a></td></tr>
						
							</c:forEach>
						</table>
					</td>
					
				</tr>
				
				
			</table>
		
		</div>
	
	</div>
</body>


</html>
