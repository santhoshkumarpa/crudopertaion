
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
        <c:forEach var="country" items="${datasList}">
<form action="/?action=update" method="post">

    <label>Id: </label>
    <input type="text" name="id" id="id"  value="<c:out value='${datasList[0].id}' />"">
    <br>
    <label>Name: </label>
    <input type="text" name="name" id="name" value="${country.name}">
    <br>
    <input type="submit" value="submit">
</form>
</c:forEach>
</body>
</html>