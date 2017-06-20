<!DOCTYPE html>
<html>
<head>	
	<title>Insert New Star</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>INSERT NEW STAR</h2>
		</div>
	</div>
	
	<div id="container">
		<form action="InsertNewStarServlet" method="post">
			<input type="hidden" name="command" value="LOGIN" />
			<input type="submit" value="Return to Dashboard" class="save"
					onclick="window.location.href='DashboardMainPage.jsp'; return false;"
					class="DashBoardServlet"/><br>
			Name (First and Last):<br>
			<input type="text" name="name"><br>
			Date of Birth (Format: MM/DD/YYYY):<br>
			<input type="text" name="dob"><br>
			Photo URL:<br>
			<input type="text" name="photoURL"><br>
			
			<input type="submit" value="Insert"/>
			
		</form>
	
	</div>
</body>
</html>