<!DOCTYPE html>
<html>

<head>
	<title>Add Movie Fail Page</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FAILED TO ADD MOVIE</h2>
		</div>
	</div>
	
	<div id="container">
		
		Error:
		<%
			String missingFieldsError = (String)request.getAttribute("missingFieldsError");
			String yearError = (String)request.getAttribute("yearError");
			String executionError = (String)request.getAttribute("executionError");
			if (missingFieldsError != null)
			{ %>
				<%= missingFieldsError %> <%
			}
			else if (yearError != null)
			{ %>
				<%= yearError %> <%
			}
			else if (executionError != null)
			{ %>
				<%= executionError %> <%
			} %>
				
		Click
		
		<input type="submit" value="here" 
		onclick="window.location.href='AddMovie.jsp'; return false;"/>
		
		to try again!				
	</div>
</body>

</html>