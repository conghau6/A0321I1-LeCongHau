<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="controler.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2021
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
<table>
    <caption>Danh sách khách hàng</caption>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerListServlet}">
    <tr>
        <td>${customer.name}</td>
        <td>${customer.dateOfBirth}</td>
        <td>${customer.diaChi}</td>
        <td>
            <img src="<c:url value="${customer.urlImage}"/>" alt="ảnh">
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
