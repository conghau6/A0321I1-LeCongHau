<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<p>
    <a href="/customer">Back to list</a>
</p>
<form method="post" >
    <div>ID:</div>
    <input type="text" disabled name="id" value="${customer.id}">
    <div>Name:</div>
    <input type="text" disabled name="name" value="${customer.name}">
    <div>Email:</div>
    <input type="email" disabled name="email" value="${customer.email}">
    <div>Address:</div>
    <input type="text" disabled name="address" value="${customer.address}">
</form>
</body>
</html>
