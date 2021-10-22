<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/15/2021
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<p>
    <a href="/users">Return the list</a>
</p>
<form method="post" action="/users">
    <input type="hidden" name="id" value="${user.id}">
    <p>Name</p>
    <input type="text" value="${user.name}" name="name">
    <p>Email</p>
    <input type="email" value="${user.email}" name="email">
    <p>Country</p>
    <input type="text" value="${user.country}" name="country">
    <input type="submit" value="Cập Nhật">
</form>
</body>
</html>
