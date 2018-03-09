<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editArtworkServlet" method="post">
Title: <input type="text" name="Title" value = "${itemToEdit.artworkTitle}"><br />
Artist: <input type = "text" name="Artist" value = "${itemToEdit.artworkArtist}"><br />
Media: <input type = "text" name="Media" value = "${itemToEdit.artworkMedia}"><br />
Year: <input type = "text" name="Year" value = "${itemToEdit.artworkYear}"><br />
Value: <input type = "text" name="Value" value = "${itemToEdit.artworkValue}"><br />
<input type = "hidden" name = "id" value="${itemToEdit.ID}">
<input type = "submit" value = "Save Edited Item">
</form>
</body>
</html>