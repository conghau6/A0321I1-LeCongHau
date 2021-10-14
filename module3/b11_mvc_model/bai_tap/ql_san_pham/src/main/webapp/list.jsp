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
        html {
            font-family: 'DM Sans', sans-serif;
        }
        body {
            position: relative;
        }
        .container {
            width: 70%;
            margin: 0 auto;
            position: relative;
        }
        .color {
            position: absolute;
            filter: blur(150px);
        }
        .color:nth-child(1) {
            top: -350px;
            width: 1000px;
            height: 600px;
            background-color: #fab3d6;
        }
        .color:nth-child(2) {
            bottom: -150px;
            left: 100px;
            width: 500px;
            height: 500px;
            background-color: #fffd87;
        }
        .color:nth-child(3) {
            bottom: -150px;
            right: 10px;
            width: 500px;
            height: 400px;
            background-color: #00d2ff;
        }
        .wrap {
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 100%;
            height: 36px;
        }
        h1 {
            margin: 10px;
            font-size: 40px;
            background-image: linear-gradient(to right bottom, #07abff, #ffc254);
            color: transparent;
            -webkit-background-clip:text;
        }
        img {
            width: 80px;
            height: 80px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th {
            width: calc(100% / 9);
        }
        th, td {
            border: 1px solid #000;
            text-align: center;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .form-search {
            margin: 0;
            height: 100%;
        }
        .form-search button {
            width: 60px;
            height: 100%;
            background-color: #4fa005;
            color: #fff;
            border: none;
            outline: none;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            border-radius: 10px;
            cursor: pointer;
        }
        input {
            height: 100%;
            border-radius: 10px;
            border: 1px solid #ccc;
            padding: 0 10px;
            outline: none;
            font-size: 18px;
            transform: translateY(-17%);
        }
        .update, .delete {
            text-decoration: none;
            font-size: 16px;
        }
        .title {
            text-decoration: none;
        }
        .edit-icon, .delete-icon  {
            font-size: 18px;
            padding-right: 5px;
        }
        .update {
            color: #083aff;
        }
        .delete {
            color: #ff2121;
        }
        .user-icon, .search-icon {
            padding-right: 5px;
            font-size: 24px;
        }
        .add-user {
            color: #03bb44;
            font-size: 24px;
            font-weight: 500;
        }
        .message {
            margin-top: 30px;
            margin-bottom: 20px;
            font-size: 18px;
        }
        .name-product {
            text-decoration: none;
            font-size: 16px;
            font-weight: 600;
            color: #000;
        }
    </style>
</head>
<body>
<div class="color"></div>
<div class="color"></div>
<div class="color"></div>
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
