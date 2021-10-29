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
                    <li class="nav-item">
                        <a class="nav-link" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item active">
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
        <a href="/service">Quản lý dịch vụ</a>
    </p>
    <p class="">
        <a class="add-new" href="/service?action=create">
            Thêm mới dịch vụ <i class="fas fa-user-plus"></i>
        </a>
    </p>
    <div class="container list-container">
        <table id="list" class="table">
            <thead>
            <tr>
                <th>Service Id</th>
                <th>Service Name</th>
                <th>Service Area</th>
                <th>Service Cost</th>
                <th>Service Max People</th>
                <th>Rent Type</th>
                <th>Service Type</th>
                <th>Standard Room</th>
                <th>Description</th>
                <th>Pool Area</th>
                <th>Num Of Floor</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="service" items="${serviceList}">
                <tr>
                    <td>${service.serviceId}</td>
                    <td>${service.serviceName}</td>
                    <td>${service.serviceArea}</td>
                    <td>${service.serviceCost}</td>
                    <td>${service.serviceMaxPeople}</td>
                    <td>${service.rentTypeName}</td>
                    <td>${service.serviceTypeName}</td>
                    <td>${service.standardRoom}</td>
                    <td>${service.descriptionOtherConvenient}</td>
                    <td>${service.poolArea}</td>
                    <td>${service.numberOfFloors}</td>
                    <td>
                        <a class="edit" href="/service?action=edit&id=${service.serviceId}">
                            <i class="far fa-edit"></i>
                        </a>
                    </td>
                    <td>
                        <a class="delete" href="/service?action=delete&id=${service.serviceId}">
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
