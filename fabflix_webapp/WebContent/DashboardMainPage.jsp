<!DOCTYPE html>
<html>

<head>
	<title>Dashboard</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Dashboard</h2>
		</div>
	</div>
	
	<div id="container">
					
		<input type="hidden" name="command" value="LOGIN" />
		
		<table>
			<tbody>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Insert a new star" class="save" 
					onclick="window.location.href='InsertNewStar.jsp'; return false;"
					class="InsertNewStarServlet"/></td>
					
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Provide metadata" class="save"
					onclick="window.location.href='MetadataServlet'; return false;"
					class="MetadataServlet"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Add a movie" class="save"
					onclick="window.location.href='AddMovie.jsp'; return false;"
					class="AddMovieServlet"/></td>
				</tr>
				
			</tbody>
		</table>

				
	</div>
</body>

</html>










