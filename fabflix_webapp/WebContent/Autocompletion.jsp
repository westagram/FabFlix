<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fabflix.*" %>

<html>
<body>
<table>
	<c:forEach var = "m" items = "${movies}"> 
	<tr>
		<td> 
		
			<div>
			<a href = "SingleMovieServlet?movieID=${m.movie_id}"> ${m.title}</a>
			</div>
		
		</td>	
	</tr>
	</c:forEach> 
</table>
</body>
</html>