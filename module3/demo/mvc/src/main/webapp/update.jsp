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
    <p>Name:</p>
    <input type="text" name="name" value="${student.name}">
    <p>Date of birth:</p>
    <input type="text" name="dateOfBirth" value="${student.dateOfBirth}">
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
