<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/23/2021
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer</title>
    <!-- fontaweasome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="/assert/css/base.css">
    <link rel="stylesheet" href="/assert/css/style.css">
    <style>
        body {
            padding: 10px;
            background: linear-gradient(
                    51deg, #ddecf6,#a076b1);
        }

        .container {
            width: 100%;
            max-width: 700px;
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
    </style>
</head>
<body>
<div class="app">
    <div class="container">
        <div class="title">Chỉnh sửa thông tin bệnh án</div>
        <form action="/benhAn" method="post">
            <input type="hidden" name="action" value="edit">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Mã Bệnh Án</span>
                    <input type="text" required name="maBenhAn" value="${benhAn.maBenhAn}" readonly>
                </div>
                <div class="input-box">
                    <span class="details">Mã Bệnh Nhân</span>
                    <input type="text" required name="maBenhNhan" value="${benhAn.maBenhNhan}" readonly>
                </div>
                <div class="input-box">
                    <span class="details">Tên Bệnh Nhân</span>
                    <input type="text" required name="tenBenhNhan" value="${benhAn.tenBenhNhan}">
                    <c:if test="${errName!=null}">
                        <p style="color: red">${errName}</p>
                    </c:if>
                </div>
                <div class="input-box">
                    <span class="details">Ngày Nhập Viện</span>
                    <input type="date" required name="ngayNhapVien" value="${benhAn.ngayNhapVien}">
                </div>
                <div class="input-box">
                    <span class="details">Ngày Ra Viện</span>
                    <input type="date" required name="ngayRaVien" value="${benhAn.ngayRaVien}">
                </div>
                <div class="input-box">
                    <span class="details">Lý Do Nhập Viện</span>
                    <input type="text" required name="lyDo" value="${benhAn.lyDo}">
                </div>

            </div>
            <div class="button">
                <input type="submit" value="Cập nhật">
            </div>
        </form>
    </div>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#list').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        })
    })
</script>
</body>
</html>
