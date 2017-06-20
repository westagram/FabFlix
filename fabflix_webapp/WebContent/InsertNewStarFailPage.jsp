<!DOCTYPE html>
<html>

<head>
	<title>Insert New Star Fail Page</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FAILED TO INSERT NEW STAR</h2>
		</div>
	</div>
	
	<div id="container">
		
		Error:
		<%
			String noNameError = (String)session.getAttribute("noNameError");
			String nameError = (String)session.getAttribute("nameError");
			String dateError = (String)session.getAttribute("dateError");
			String executionError = (String)session.getAttribute("executionError");
			if (noNameError != null)
			{ %>
				<%= noNameError %> <%
			}
			else if (nameError != null)
			{ %>
				<%= nameError %> <%
			}
			else if (dateError != null)
			{ %>
				<%= dateError %> <%
			}
			else if (executionError != null)
			{ %>
				<%= executionError %> <%
			} %>
				
		Click
		
		<input type="submit" value="here" 
		onclick="window.location.href='InsertNewStar.jsp'; return false;"/>
		
		to try again!				
	</div>
</body>

</html>