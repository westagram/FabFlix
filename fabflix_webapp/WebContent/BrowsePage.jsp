<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- </%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html>

<head>
	<title>BrowsePage</title>
	<style>
		#genres td {
			padding: 0 15px 0 15px;
		}
	</style>
</head>

<input type="submit" value="Go to Cart" class="save"
					onclick="window.location.href='ShoppingCart.jsp'; return false;"
					class="ShoppingCartervlet"/>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>BROWSE PAGE</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Browse By Title</h3>
		<table>
			<tbody>
				<tr>
					<td><a href="BrowsePageServlet?title_option=0">0</a> |</td>
					<td><a href="BrowsePageServlet?title_option=1">1</a> |</td>
					<td><a href="BrowsePageServlet?title_option=2">2</a> |</td>
					<td><a href="BrowsePageServlet?title_option=3">3</a> |</td>
					<td><a href="BrowsePageServlet?title_option=4">4</a> |</td>
					<td><a href="BrowsePageServlet?title_option=5">5</a> |</td>
					<td><a href="BrowsePageServlet?title_option=6">6</a> |</td>
					<td><a href="BrowsePageServlet?title_option=7">7</a> |</td>
					<td><a href="BrowsePageServlet?title_option=8">8</a> |</td>
					<td><a href="BrowsePageServlet?title_option=9">9</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?title_option=A">A</a> |</td>
					<td><a href="BrowsePageServlet?title_option=B">B</a> |</td>
					<td><a href="BrowsePageServlet?title_option=C">C</a> |</td>
					<td><a href="BrowsePageServlet?title_option=D">D</a> |</td>
					<td><a href="BrowsePageServlet?title_option=E">E</a> |</td>
					<td><a href="BrowsePageServlet?title_option=F">F</a> |</td>
					<td><a href="BrowsePageServlet?title_option=G">G</a> |</td>
					<td><a href="BrowsePageServlet?title_option=H">H</a> |</td>
					<td><a href="BrowsePageServlet?title_option=I">I</a> |</td>
					<td><a href="BrowsePageServlet?title_option=J">J</a> |</td>
					<td><a href="BrowsePageServlet?title_option=K">K</a> |</td>
					<td><a href="BrowsePageServlet?title_option=L">L</a> |</td>
					<td><a href="BrowsePageServlet?title_option=M">M</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?title_option=N">N</a> |</td>
					<td><a href="BrowsePageServlet?title_option=O">O</a> |</td>
					<td><a href="BrowsePageServlet?title_option=P">P</a> |</td>
					<td><a href="BrowsePageServlet?title_option=Q">Q</a> |</td>
					<td><a href="BrowsePageServlet?title_option=R">R</a> |</td>
					<td><a href="BrowsePageServlet?title_option=S">S</a> |</td>
					<td><a href="BrowsePageServlet?title_option=T">T</a> |</td>
					<td><a href="BrowsePageServlet?title_option=U">U</a> |</td>
					<td><a href="BrowsePageServlet?title_option=V">V</a> |</td>
					<td><a href="BrowsePageServlet?title_option=W">W</a> |</td>
					<td><a href="BrowsePageServlet?title_option=X">X</a> |</td>
					<td><a href="BrowsePageServlet?title_option=Y">Y</a> |</td>
					<td><a href="BrowsePageServlet?title_option=Z">Z</a></td>
				</tr>
			</tbody>
		</table>
		<h3>Browse by Genre</h3>
		<table id="genres">
			<tbody>
				<tr>
					<td><a href="BrowsePageServlet?genresID=907000">Action</a></td>
					<td><a href="BrowsePageServlet?genresID=907001">Adventure</a></td>
					<td><a href="BrowsePageServlet?genresID=764003">Animation</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=48001">Classic</a></td>
					<td><a href="BrowsePageServlet?genresID=907003">Comedy</a></td>
					<td><a href="BrowsePageServlet?genresID=150005">Coming-of-Age-Drama</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=855203">Crime</a></td>
					<td><a href="BrowsePageServlet?genresID=788009">Documentary</a></td>
					<td><a href="BrowsePageServlet?genresID=907002">Drama</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=492206">Biography</a></td>
					<td><a href="BrowsePageServlet?genresID=872006">History</a></td>
					<td><a href="BrowsePageServlet?genresID=872012">Family</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=907009">Fantasy</a></td>
					<td><a href="BrowsePageServlet?genresID=907006">Foreign</a></td>
					<td><a href="BrowsePageServlet?genresID=150008">Gangster</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=907004">Horror</a></td>
					<td><a href="BrowsePageServlet?genresID=422610">Indie</a></td>
					<td><a href="BrowsePageServlet?genresID=525210">James Bond</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=855209">Music</a></td>
					<td><a href="BrowsePageServlet?genresID=764013">Musical</a></td>
					<td><a href="BrowsePageServlet?genresID=788010">Musical/Performing Arts</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=764014">Mystery</a></td>
					<td><a href="BrowsePageServlet?genresID=631003">Roman</a></td>
					<td><a href="BrowsePageServlet?genresID=907008">Romance</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=907007">Sci-Fi</a></td>
					<td><a href="BrowsePageServlet?genresID=764017">Sport</a></td>
					<td><a href="BrowsePageServlet?genresID=525208">Spy</a></td>
				</tr>
				<tr>
					<td><a href="BrowsePageServlet?genresID=422607">Suspense</a></td>
					<td><a href="BrowsePageServlet?genresID=907005">Thriller</a></td>
					<td><a href="BrowsePageServlet?genresID=872010">War</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>