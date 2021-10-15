<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/15/2021
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap" rel="stylesheet">
    <style>
        html {
            font-family: 'DM Sans', sans-serif;
        }
    </style>
</head>
<body>
<p>
    <a href="/users?action=create">Add new user</a>
</p>
<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Country</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
        <c:forEach var="user" items="${listUser}" varStatus="loop">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/users?action=update&id=${user.id}">Edit</a></td>
            <td><a href="/users?action=delete&id=${user.id}">Delete</a></td>
        </tr>
        </c:forEach>
</table>
</body>
</html>
