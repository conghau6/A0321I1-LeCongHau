<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2021
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        <c:if test="${vie!=null}">
            ${eng} có nghĩa là ${vie}
        </c:if>
        <c:if test="${vie==null}">
            Không có trong từ điển
        </c:if>
    </h2>
</body>
</html>
