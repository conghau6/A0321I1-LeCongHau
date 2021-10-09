<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post">
    <p>ID:</p>
    <input type="text" name="id" value="${student.id}">
    <p>Name:</p>
    <input type="text" name="name" value="${student.name}">
    <p>Date of birth:</p>
    <input type="text" name="dateOfBirth" value="${student.dateOfBirth}">
    <p>Gender:</p>
    <input type="number" min="0" max="1" step="1" name="gender" value="${student.gender}">
    <p>Grade:</p>
    <input type="text" name="grade" value="${student.grade}">
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
