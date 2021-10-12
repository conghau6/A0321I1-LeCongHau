<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap" rel="stylesheet">
    <style>
        html {
            font-family: 'DM Sans', sans-serif;
        }

        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .container {
            width: 400px;
            margin: 20px auto;
        }
        h3 {
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>Thêm mới sản phẩm</h3>
    <div>
        <form method="post" action="/product">
            <input type="hidden" name="action" value="create">
            <label for="id">ID: </label>
            <input type="text" id="id" name="id" placeholder="Id..">

            <label for="name">Tên sản phẩm</label>
            <input type="text" id="name" name="name" placeholder="Tên sản phẩm..">

            <label for="type">Loại sản phẩm</label>
            <select id="type" name="type">
                <option value="Điện thoại">Điện thoại</option>
                <option value="Laptop">Laptop</option>
                <option value="PC">PC</option>
            </select>

            <label for="desc">Mô tả</label>
            <input type="text" id="desc" name="desc" placeholder="Mô tả sản phẩm..">

            <label for="price">Giá</label>
            <input type="text" id="price" name="price" placeholder="Tên sản phẩm..">

            <label for="urlImage">Ảnh</label>
            <input type="text" id="urlImage" name="urlImage" placeholder="Link ảnh sản phẩm..">
            <input type="submit" value="Thêm">
        </form>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
</body>
</html>
