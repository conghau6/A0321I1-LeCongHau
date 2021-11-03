<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/23/2021
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="/assert/css/base.css">
    <link rel="stylesheet" href="/assert/css/style.css">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 10px;
            background: linear-gradient(
                    51deg, #ddecf6,#a076b1);
        }

        .container {
            width: 100%;
            max-width: 400px;
            background: #fff;
            padding: 25px 30px;
            border-radius: 5px;
        }

        .container .title {
            font-size: 25px;
            font-weight: 500;
            position: relative;
        }

        .container .title::before {
            content: "";
            left: 0;
            bottom: 0;
            position: absolute;
            height: 3px;
            width: 30px;
            background: linear-gradient(135deg, #71b7e6,#9b59b6);
        }

        .container form .user-details {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin: 20px 0 12px 0;
        }

        form .user-details .input-box {
            margin-bottom: 15px;
            width: calc(100% / 2 - 20px);
        }

        .user-details .input-box .details {
            display: block;
            font-weight: 500;
        }

        .user-details .input-box input,
        .user-details .input-box select{
            height: 45px;
            width: 100%;
            outline: none;
            border-radius: 5px;
            border: 1px solid #ccc;
            padding-left: 15px;
            font-size: 16px;
            border-bottom-width: 2px;
            transition: all 0.3s ease;
        }

        .user-details .input-box input:focus,
        .user-details .input-box input:valid,
        .user-details .input-box select:focus{
            border-color: #9b59b6;
        }

        form .gender-details .gender-title {
            font-size: 20px;
            font-weight: 500;
        }

        form .gender-details .category {
            display: inline-block;
            margin: 0 10px;
        }

        .gender-details .category input {
            transform: scale(1.2);
        }

        .gender-details label {
            font-size: 20px;
            font-weight: 500;
        }

        form .button {
            height: 45px;
        }

        form .button input {
            height: 100%;
            width: 100%;
            outline: none;
            color: #fff;
            background: linear-gradient(135deg, #71b7e6,#9b59b6);
            border: none;
            font-size: 18px;
            font-weight: 500;
            letter-spacing: 1px;
            border-radius: 5px;
        }

        form .button input:hover {
            background: linear-gradient(135deg,#9b59b6, #71b7e6);
            cursor: pointer;
        }

        @media screen and (max-width: 584px) {
            .container {
                max-width: 100%;
            }
            form .user-details .input-box {
                margin-bottom: 15px;
                width: 100%;
            }
            .container form .user-details{
                max-height: 300px;
                overflow-y: scroll;
            }
            .user-details::-webkit-scrollbar{
                width: 0;
            }
        }

        form .user-details .input-box {
            margin-bottom: 15px;
            width: 100%;
        }

        .input-box:last-child {
            display: flex;
            align-items: center;
        }

        input[type=checkbox]{
            display: inline-block;
            width: auto !important;
        }

        label:last-child {
            margin: 0 !important;
            margin-left: 5px !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="title">Đăng nhập</div>
    <form action="/login" method="post">
        <input type="hidden" name="action" value="login">
        <div class="user-details">
            <div class="input-box">
                <span class="details">Tên đăng nhập</span>
                <input type="text" required name="username">
            </div>
            <div class="input-box">
                <span class="details">Mật khẩu</span>
                <input type="password" required name="password">
                <p style="color: red">${message}</p>
            </div>
            <div class="input-box">
                <input id="remember" type="checkbox" name="chkRemember" value="ON">
                <label for="remember">Remember me</label>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Đăng nhập">
        </div>
    </form>
</div>
</body>
</html>
