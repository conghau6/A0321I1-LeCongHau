<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/15/2021
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post" action="/users">
    <input type="hidden" name="action" value="create">
    <input type="text" placeholder="id" name="id">
    <p>Name</p>
    <input type="text" placeholder="name" name="name">
    <p>Email</p>
    <input type="email" placeholder="email" name="email">
    <p>Country</p>
    <input type="text" placeholder="country" name="country">
    <input type="submit" value="Thêm Mới">
</form>
</body>
</html>
