<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<center>
        <h1>Countries Management</h1>
        <h2>
            <a href="/?action=new">Add New Country</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/?list">List All Countries</a>
             
        </h2>
    </center>

<body>
    <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>List of Books</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>name</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="country" items="${datasList}">
                    <tr>
                        <td><c:out value="${country.id}" /></td>
                        <td><c:out value="${country.name}" /></td>
                        <td>
                            <a href="/?action=edit&id=<c:out value='${country.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/DeleteData?id=<c:out value='${country.id}' />">Delete</a>                     
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>   
</body>

</html>
