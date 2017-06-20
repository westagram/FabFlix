<!DOCTYPE html>
<html>
<head>	
	<title>Add a Movie</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>ADD A MOVIE</h2>
		</div>
	</div>
	
	<div id="container">
		<form action="AddMovieServlet" method="post">
			
			<input type="hidden" name="command" value="LOGIN" />
			<input type="submit" value="Return to Dashboard" class="save"
					onclick="window.location.href='DashboardMainPage.jsp'; return false;"
					class="DashBoardServlet"/><br>
			Title:<br>
			<input type="text" name="title"><br>
			Year:<br>
			<input type="text" name="year"><br>
			Director:<br>
			<input type="text" name="director"><br>
			Star First Name:<br>
			<input type="text" name="starFirstName"><br>
			Star Last Name:<br>
			<input type="text" name="starLastName"><br>
			Genre Name:<br>
			<input type="text" name="genreName"><br>
			
			<input type="submit" value="Add"/>
			
		</form>
	
	</div>
</body>
</html>