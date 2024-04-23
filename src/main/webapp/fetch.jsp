<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Moviedto"%>
<%@page import="dao.MovieDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
</head>
<body>
	<h1 align="center"> List of All Movies using JSP</h1>
	<% 
       List<Moviedto> list = (List<Moviedto>)request.getAttribute("list");
	%>
	
	<div align="center">
        <table border="1">  
        	<tr>
                <th>Name</th>
                <th>Image</th>
                <th>Language</th>
                <th>Genre</th>
                <th>Rating</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            
            <%for(Moviedto movie:list){ %>
            	<tr>
	                <th><%=movie.getName() %></th>
	                <th><img height="75px" width="75px" alt="<%=movie.getName() %>" src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movie.getPicture())%>"></th>
	                <th><%=movie.getLanguage() %></th>
	                <th><%=movie.getGenre() %></th>
	                <th><%=movie.getRating() %></th>
	                <th><a href="edit-movie?id=<%=movie.getId() %>"><button>Edit</button></a></th>
	                <th><a href="delete-movie?id=<%=movie.getId() %>">Delete</th>
           		 </tr>
            <%} %>
     </table>
     </div>  
     <br>
     <div align="center">
    	<a href='home.html'><button>Back</button></a>
     </div>                        		  		    			
</body>
</html>

