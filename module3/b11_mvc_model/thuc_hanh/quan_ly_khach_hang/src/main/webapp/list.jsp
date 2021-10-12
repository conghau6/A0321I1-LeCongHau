<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/9/2021
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
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
<h1>Customer</h1>
<p>
    <a href="/customer?action=create">Create new customer</a>
</p>
<p>
    <c:if test='${err!=null}'>
        ${err}
    </c:if>
    <c:if test='${err==null}'>
        ${message}
    </c:if>
</p>
<table border="1">
    <tr>
        <td>No</td>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${customerListServlet}" var="customer" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${customer.id}"></c:out></td>
            <td><a href="/customer?action=view&id=${customer.id}"><c:out value="${customer.name}"></c:out></a></td>
            <td><c:out value="${customer.email}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><a href="/customer?action=update&id=${customer.id}">Update</a></td>
            <td><a href="/customer?action=delete&id=${customer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
