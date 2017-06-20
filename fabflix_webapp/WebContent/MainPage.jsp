<!DOCTYPE html>
<html>

<head>
	<title>Main Menu</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<input type="submit" value="Go to Cart" class="save"
					onclick="window.location.href='ShoppingCart.jsp'; return false;"
					class="ShoppingCartervlet"/>
<body>
<script src="AutocompleteJs.js"> </script>
	<div id="wrapper">
		<div id="header">
			<h2>MAIN MENU</h2>
		</div>
	</div>
	
	<div id="container">
					
		<input type="hidden" name="command" value="LOGIN" />
		
		<table>
			<tbody>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Search Page" class="save" 
					onclick="window.location.href='SearchPage.jsp'; return false;"
					class="SearchPageServlet"/></td>
					
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Browse Page" class="save"
					onclick="window.location.href='ActualBrowsePageServlet'; return false;"
					class="BrowsePageServlet"/></td>
				</tr>
				
			</tbody>
		</table>
		
		<h3>Quick Search</h3>
		<form name='myForm' action="AutocompletionServlet" method="post">
		Movie Name: <input id='mySearch' type='text' oninput="ajaxFunction();" name='input' /> 
		<input type="submit" value="Search"/>
		<p id="demo"></p>
		</form>

				
	</div>
</body>

</html>











