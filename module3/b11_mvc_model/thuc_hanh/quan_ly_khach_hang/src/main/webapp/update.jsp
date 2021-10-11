<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap" rel="stylesheet">
    <style>
        html {
            font-family: 'DM Sans', sans-serif;
        }
    </style>
</head>
<body>
<p>
    <a href="/customer">Back to list</a>
</p>
<form method="post" >
    <input type="hidden" name="action" value="update">
    <div>ID:</div>
    <input type="text" name="id" value="${customer.id}">
    <div>Name:</div>
    <input type="text" name="name" value="${customer.name}">
    <div>Email:</div>
    <input type="email" name="email" value="${customer.email}">
    <div>Address:</div>
    <input type="text" name="address" value="${customer.address}">
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
