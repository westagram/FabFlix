<!DOCTYPE html>
<html>

<head>
	<title>Add Movie Success Page</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>

<body>
	<%
		boolean movieExists = (boolean)request.getAttribute("movieExists");
		if (movieExists)
		{ %>
			<div id="wrapper">
				<div id="header">
					<h2>UPDATED MOVIE SUCCESSFULLY</h2>
				</div>
			</div>
		
			<div id="container">
		
				Movie successfully updated. Click <input type="submit" value="here"
					onclick="window.location.href='DashboardMainPage.jsp'; return false;" />
		
				to return to dashboard!
			</div> <%
		}
		else
		{ %>
			<div id="wrapper">
				<div id="header">
					<h2>ADDED MOVIE SUCCESSFULLY</h2>
				</div>
			</div>
		
			<div id="container">
		
				Movie successfully added. Click <input type="submit" value="here"
					onclick="window.location.href='DashboardMainPage.jsp'; return false;" />
		
				to return to dashboard!
			</div> <%
		} %>
</body>

</html>