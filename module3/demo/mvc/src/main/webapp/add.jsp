<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/9/2021
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>ID:</p>
    <input type="text" name="id">
    <p>Name:</p>
    <input type="text" name="name">
    <p>Date of birth:</p>
    <input type="text" name="dateOfBirth">
    <p>Gender:</p>
    <input type="text" type="number" min="0" max="1" step="1" name="gender">
    <p>Grade:</p>
    <input type="text" name="grade">
    <input type="submit" id="submit">
</form>
</body>
</html>
