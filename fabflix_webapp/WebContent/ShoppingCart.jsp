<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- </%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>

<html>

<head>	
	<title>Shopping Cart</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<input type="submit" value="Back to Main" class="save"
					onclick="window.location.href='MainPage.jsp'; return false;"/>	

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CART INFORMATIONS</h2>
		</div>
		<div>
			<h2>
			<input type="submit" value="Check Out" class="save"
					onclick="window.location.href='CheckOutServlet'; return false;"/>	
			</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<table>
			
				<tr>
					<th>Movie ID</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Actions</th>
					
				</tr>
				
				<c:forEach var = "movie" items = "${movieList}">
					<tr>
					
						<c:url var="deleteLink" value="ShoppingCartServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="movieID" value="${movie[0].movie_id}" />
						</c:url>
						
						<c:url var="updateLink" value="StudentControllerServlet">
							<c:param name="command" value="UPDATE" />
							<c:param name="movieID" value="${movie[0].movie_id}" />
						</c:url>
					
						<td> ${movie[0].movie_id} </td>
						<td> ${movie[0].title} </td>
						<td> ${movie.size()}</td>
						<td> 
							<a type="submit" href="CartUpdateServlet?command=UPDATE&movieID=${movie[0].movie_id}">Update</a> 
							 | 
							<a href="CartUpdateServlet?command=DELETE&movieID=${movie[0].movie_id}"
							onclick="if (!(confirm('Are you sure you want to delete this movie?'))) return false">
							Delete</a>	
						</td>
						
					</tr>
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>
