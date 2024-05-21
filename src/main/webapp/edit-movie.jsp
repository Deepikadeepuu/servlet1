<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Moviedto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
</head>
<body>
	<%
	Moviedto movie = (Moviedto) request.getAttribute("movie");
	%>
	<div align="center">
		<h1>Update Movie</h1>
		<form action="edit-movie" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="<%=movie.getId()%>">
			Movie Name: <input type="text" name="name"
				value="<%=movie.getName()%>" required><br> Movie
			Language: <select name="language" required="required">
				<option selected value="<%=movie.getLanguage()%>"><%=movie.getLanguage()%></option>
				<option>Kannada</option>
				<option>English</option>
				<option>Hindi</option>
				<option>Telgu</option>
				<option>Tamil</option>
			</select><br> Rating: <input type="text" name="rating" value="<%=movie.getRating()%>"><br>
			Image: <input type="file" name="picture"> <img height="75px"
				width="75px" alt="<%=movie.getName()%>"
				src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movie.getPicture())%>">
			<br> Genre: <select name="genre" required="required">
				<option selected value="<%=movie.getGenre()%>"><%=movie.getGenre()%></option>
				<option>Horror</option>
				<option>Comedy</option>
				<option>Action</option>
				<option>Thriller</option>
					<option>Romantic</option>
						<option>Fighting</option>
			</select><br> <br>
			<button>Update</button>
		</form>
	</div>
</body>
</html>