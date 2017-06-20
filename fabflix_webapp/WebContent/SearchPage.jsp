<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>	
	<title>Search Page</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<input type="submit" value="Go to Cart" class="save"
					onclick="window.location.href='ShoppingCart.jsp'; return false;"
					class="ShoppingCartServlet"/>
<input type="submit" value="Go to Main" class="save"
					onclick="window.location.href='MainPage.jsp'; return false;"/>					

<body>
	<div id="wrapper">
		<div id="header">
			<h2>SEARCH PAGE</h2>
		</div>
	</div>
	
	<div id="container">
	<form action="SearchPageServlet" method="post">
			
			<input type="hidden" name="command" value="LOGIN" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Search:</label></td>
						<td><input type="text" name="search" /></td>
						<td><select name="searchOption">
							<option value="title">Title</option>
							<option value="year">Year</option>
							<option value="director">Director</option>
							<option value="first_name">Star's First Name</option>
							<option value="last_name">Star's Last Name</option>
							<option value="full_name">Star's Full Name</option>
						</select></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Search"/></td>
					</tr>
				</tbody>
			</table>
		</form>
	
	</div>
</body>
</html>