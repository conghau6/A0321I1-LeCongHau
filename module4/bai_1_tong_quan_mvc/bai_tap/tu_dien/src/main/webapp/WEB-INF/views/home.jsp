<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2021
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result">
    <table>
        <tr>
            <td>Tiếng anh: </td>
            <td><input type="text" name="eng"></td>
        </tr>
    </table>
    <input type="submit" value="Dịch">
</form>
</body>
</html>
