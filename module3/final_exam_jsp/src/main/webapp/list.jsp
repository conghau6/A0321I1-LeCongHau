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
    <div class="container list-container">
        <table id="list" class="table">
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã bệnh án</th>
                <th>Mã bệnh nhân</th>
                <th>Tên bệnh nhân</th>
                <th>Ngày nhập viện</th>
                <th>Ngày ra viện</th>
                <th>lý do nhập viện</th>
                <th>Tác vụ</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="BenhAn" items="${listBenhAn}" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${BenhAn.maBenhAn}</td>
                    <td>${BenhAn.maBenhNhan}</td>
                    <td>${BenhAn.tenBenhNhan}</td>
                    <td>${BenhAn.ngayNhapVien}</td>
                    <td>${BenhAn.ngayRaVien}</td>
                    <td>${BenhAn.lyDo}</td>
                    <td>
                        <a class="edit" href="/benhAn?action=edit&id=${BenhAn.maBenhNhan}">
                            <i class="far fa-edit"></i>
                        </a>
                        <button class="delete" onclick="_delete('${BenhAn.maBenhNhan}')" data-toggle="modal" data-target="#exampleModalCenter">
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
                    <form method="post" action="/benhAn">
                        <input type="hidden" name="action" value="delete">
                        <p id="message">Xoá bệnh nhân </p>
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
            "pageLength": 2
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
