<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Player Roster</title>
</head>
<body>


<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allPlayers}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.team}</td>
	<td>${currentitem.name}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToPlayer">
<input type="submit" value="delete" name="doThisToPlayer">
<input type="submit" value="add" name="doThisToPlayer">
</form>

</body>
</html>