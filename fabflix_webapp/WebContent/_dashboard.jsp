<!DOCTYPE html>
<html>

<head>
	<title>Dashboard</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>DASHBOARD</h2>
		</div>
	</div>
	
	<div id="container">
		
		<form action="DashboardServlet" method="post">
		
			<input type="hidden" name="command" value="DASHBOARD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login"/></td>
					</tr>
					
				</tbody>
			</table>
		</form>
				
	</div>
</body>

</html>











