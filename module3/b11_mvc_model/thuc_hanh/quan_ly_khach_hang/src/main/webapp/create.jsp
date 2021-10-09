<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/9/2021
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<p>
    <a href="/customer">Back to list</a>
</p>
<form method="post">
    <div>ID:</div>
    <input type="text" name="id">
    <div>Name:</div>
    <input type="text" name="name">
    <div>Email:</div>
    <input type="email" name="email">
    <div>Address:</div>
    <input type="text" name="address">
    <button type="submit">Thêm</button>
</form>
</body>
</html>
