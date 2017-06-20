<!DOCTYPE html>
<html>

<head>
	<title>Login Page</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css">
	<script src='https://www.google.com/recaptcha/api.js'></script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>LOGIN PAGE</h2>
		</div>
	</div>
	
	<div id="container">
		
		<form action="LoginPageServlet" method="post">
		
			<input type="hidden" name="command" value="LOGIN" />
			
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
			<div class="g-recaptcha" data-sitekey="6LcshyAUAAAAAOsz6nHp6_JQrg-B3dOXL2COs2SC"></div>
		</form>
				
	</div>
</body>

</html>











