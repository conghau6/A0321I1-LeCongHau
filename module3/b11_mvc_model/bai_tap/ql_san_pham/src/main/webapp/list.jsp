<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="assert/style.css">
    <style>

    </style>
</head>
<body>
<div class="container">
    <a class="title" href="/product">
        <h1>QUẢN LÝ SẢN PHẨM</h1>
    </a>
    <div class="wrap">
        <a class="add-user" href="/product?action=create"><i class="user-icon fas fa-user-plus"></i>Thêm mới sản phẩm</a>
        <form class="form-search" method="get">
            <input type="hidden" name="action" value="search">
            <input type="text" placeholder="Tìm kiếm" name="name">
            <button type="submit">
                <i class="search-icon fas fa-search"></i>
            </button>
        </form>
    </div>
    <p class="message">
        <c:if test='${err!=null}'>
            ${err}
        </c:if>
        <c:if test='${err==null}'>
            ${message}
        </c:if>
    </p>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Id</th>
            <th>Tên Sản Phẩm</th>
            <th>Loại</th>
            <th>Mô tả</th>
            <th>Giá</th>
            <th>Ảnh</th>
            <th>Cập Nhật</th>
            <th>Xoá</th>
        </tr>
        <c:forEach var="product" items="${productListServlet}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${product.id}</td>
                <td><a class="name-product" href="/product?action=view&id=${product.id}">${product.name}</a></td>
                <td>${product.type}</td>
                <td>${product.desc}</td>
                <td>${product.price}đ</td>
                <td>
                    <img src="${product.urlImage}" alt="Image">
                </td>
                <td>
                    <a class="update" href="/product?action=update&id=${product.id}"><i class="edit-icon fas fa-edit"></i>Cập nhật</a>
                </td>
                <td>
                    <a class="delete" href="/product?action=delete&id=${product.id}"><i class="delete-icon fas fa-trash-alt"></i>Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
</body>
</html>
