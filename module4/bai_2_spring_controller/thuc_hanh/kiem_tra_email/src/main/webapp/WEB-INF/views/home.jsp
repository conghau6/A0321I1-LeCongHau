<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2021
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/validate">
    <input type="text" name="email">
    <input type="submit" value="Kiểm tra">
</form>
<p style="color: red">${message}</p>
</body>
</html>
