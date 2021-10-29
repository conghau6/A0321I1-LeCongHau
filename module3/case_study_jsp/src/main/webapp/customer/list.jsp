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
</head>
<body>
<div class="app">
    <div class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="/assert/image/big-logo.png" alt="" class="nav-logo">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Employee</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/service">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contract</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <p class="quick-menu">
        <a href="/customer">Quản lý khách hàng</a>
    </p>
    <p class="">
        <a class="add-new" href="/customer?action=create">
            Thêm mới khách hàng <i class="fas fa-user-plus"></i>
        </a>
    </p>
    <div class="container list-container">
        <table id="list" class="table">
            <thead>
                <tr>
                    <th>Mã Khách Hàng</th>
                    <th>Loại Khách Hàng</th>
                    <th>Tên Khách Hàng</th>
                    <th>Ngày Sinh</th>
                    <th>Giới Tính</th>
                    <th>ID Card</th>
                    <th>Điện Thoại</th>
                    <th>Email</th>
                    <th>Địa Chỉ</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.customerTypeName}</td>
                        <td>${customer.customerName}</td>
                        <td>${customer.customerBirthday}</td>
                        <td>
                            <c:if test="${customer.customerGender == 1}">
                                Nam
                            </c:if>
                            <c:if test="${customer.customerGender == 0}">
                                Nữ
                            </c:if>
                        </td>
                        <td>${customer.customerIdCard}</td>
                        <td>${customer.customerPhone}</td>
                        <td>${customer.customerEmail}</td>
                        <td>${customer.customerAddress}</td>
                        <td>
                            <a class="edit" href="/customer?action=edit&id=${customer.customerId}">
                                <i class="far fa-edit"></i>
                            </a>
                        </td>
                        <td>
                            <a class="delete" href="/customer?action=delete&id=${customer.customerId}">
                                <i class="far fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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
