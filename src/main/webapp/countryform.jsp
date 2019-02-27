
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<form action="/?action=insert" method="post">
    <label>Id: </label>
    <input type="text" name="id" id="id" value="<c:out value='${datasList[0].id}' />" />
    <br>
    <label>Name: </label>
    <input type="text" name="name" id="name"value="<c:out value='${datasList[0].name}' />"/>
    <br>
    <input type="submit" value="submit">
</form>
<hr>
${datasList}
${datasList[0].id}
</body>
</html>