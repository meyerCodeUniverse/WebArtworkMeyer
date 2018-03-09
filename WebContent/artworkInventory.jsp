<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editArtworkInventoryServlet" method="post">
<table>
<c:forEach items="${requestScope.allArtwork}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.ID}"></td>
	<td>${currentitem.artworkTitle}</td>
	<td>${currentitem.artworkArtist}</td>
	<td>${currentitem.artworkMedia}</td>
	<td>${currentitem.artworkYear}</td>
	<td>${currentitem.artworkValue}</td>
</c:forEach>
</table>
<input type="submit" value="Edit Selected Item" name="doThisToItem">
<input type="submit" value="Delete Selected Item" name="doThisToItem">
<input type="submit" value="Add New Item" name="doThisToItem">
</form>
</body>
</html>