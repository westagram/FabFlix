<!DOCTYPE html>
<html>

<head>
	<title>Update Page</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	
</head>

<input type="submit" value="Back to Cart" class="save"
					onclick="window.location.href='ShoppingCart.jsp'; return false;"
					class="ShoppingCartervlet"/>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>UPDATE PAGE</h2>
		</div>
	</div>
	
	<div id="container">
		
		<form action="CartUpdateServlet" method="post">
		
			<input type="hidden" name="command" value="LOGIN" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Enter the amount:</label></td>
						<td><input type="text" name="UPDATE" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Submit"/></td>
					</tr>
					
					
				</tbody>
			</table>
		</form>
				
	</div>
</body>

</html>











