<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fabflix.*" %>

<table>
			
				<tr>
					<th>Title</th>
					<th>Year</th>
					<th>Poster</th>
					<th>Stars</th>
					<th>Add to Cart</th>
					
				</tr>
				
				<tr>
					<td><h3>${movie.title}</h3></td>
					<td> ${movie.year}</td>
					<td> <img src="${movie.bannerURL}" style="width:120px;height:150px;"></td>
					<td> 
						<table>
							<c:forEach var = "star" items = "${movie.stars}">
			
							<tr><td><a href = "SingleStarServlet?starID=${star.id}">	${star.fullName} <br/> </a></td></tr>
						
							</c:forEach>
						</table>
					</td>
					<td><a href="ShoppingCartServlet?movieID=${movie.movie_id}" onclick="if (!(confirm('Add to cart?'))) return false">Add to Cart</a></td>
					
					
				</tr>
				
				
			</table>