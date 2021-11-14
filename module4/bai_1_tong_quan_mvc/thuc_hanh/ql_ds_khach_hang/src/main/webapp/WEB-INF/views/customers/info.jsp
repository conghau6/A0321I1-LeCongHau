<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2021
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Customer Information</h3>
<form action="/customer/update" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="text" required name="id" value="${customer.id}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" required name="name" value="${customer.name}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" required name="email" value="${customer.email}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" required name="address" value="${customer.address}"></td>
        </tr>
    </table>
    <input type="submit" value="Update">
</form>
<a href="/customer/list">Back to list</a>
</body>
</html>
