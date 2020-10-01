<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a Player</title>
</head>
<body>

<form action="editPlayerServlet" method="post">
Team: <input type="text" name="team" value="${playerToEdit.team}">
Player: <input type="text" name="player" value="${playerToEdit.name}">
<input type="hidden" name="id" value="${playerToEdit.id}">
<input type="submit" value="Save Edited Player">

</form>

</body>
</html>