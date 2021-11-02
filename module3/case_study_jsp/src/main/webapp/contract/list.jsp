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
                        <a class="nav-link" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/service">Service</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/contract">Contract</a>
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
        <a href="/service">Quản lý hợp đồng</a>
    </p>
    <p class="">
        <a class="add-new" href="/contract?action=create">
            Thêm mới hợp đồng <i class="fas fa-user-plus"></i>
        </a>
    </p>
    <div class="container list-container">
        <table id="list" class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc/th>
                <th>Tiền đặt cọc</th>
                <th>Tông tiền</th>
                <th>Tên nhân viên</th>
                <th>Tên khách hàng</th>
                <th>Tên dịch vụ</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contractList}">
                <tr>
                    <td>${contract.contractId}</td>
                    <td>${contract.contractStartDate}</td>
                    <td>${contract.contractEndDate}</td>
                    <td>${contract.contractDeposit}</td>
                    <td>${contract.contractTotalMoney}</td>
                    <td>${contract.employeeName}</td>
                    <td>${contract.customerName}</td>
                    <td>${contract.serviceName}</td>
                    <td>
                        <a class="edit" href="/contract?action=edit&id=${contract.contractId}">
                            <i class="far fa-edit"></i>
                        </a>
                    </td>
                    <td>
                        <button class="delete" onclick="_delete('${contract.contractId}')" data-toggle="modal" data-target="#exampleModalCenter">
                            <i class="far fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="post" action="/contract">
                        <input type="hidden" name="action" value="delete">
                        <p id="message">Xoá hợp đồng số</p>
                        <input type="hidden" id="x" name="id_delete">
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
                            <button type="submit" class="btn btn-primary">Xoá</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
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
    function _delete(id) {
        document.getElementById("x").value = id
        let str = document.getElementById("message").textContent
        document.getElementById("message").innerHTML = str+" "+ id
    }
</script>
</body>
</html>
