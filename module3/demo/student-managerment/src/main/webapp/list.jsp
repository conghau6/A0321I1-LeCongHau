<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/19/2021
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<p>
    <a href="/action?create">Add student</a>
</p>
<p>
<form method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="name">
    <input type="submit" value="Tìm kiếm">
</form>
</p>

</body>
</html>
