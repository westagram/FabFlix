<!DOCTYPE html>
<html>

<head>
	<title>Checkout Page</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CHECKOUT</h2>
		</div>
	</div>
	
	<div id="container">
		
		<form action="CheckOutServlet" method="post">
		
			<input type="hidden" name="command" value="LOGIN" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Credit Card Number:</label></td>
						<td><input type="text" name="ccid" /></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" /></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" /></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
					<tr>
						<td><label>Expiration Date:</label></td>
						<td><input type="text" name="date" /></td>
						<td><label>Month:</label></td>
						<td><input type="text" name="month" /></td>
						<td><label>Year:</label></td>
						<td><input type="text" name="year" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Checkout"/></td>
						<td></td>
						<td><input type="submit" value="Back to Cart" class="save" 
						onclick="window.location.href='ShoppingCart.jsp'; return false;"/></td>
						<td></td>
						<td></td>
					</tr>
					
				</tbody>
			</table>
		</form>
				
	</div>
</body>

</html>











