<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2021
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result:</h1>
<c:if test="${err.equals('')}">
    <c:out value="${err}"></c:out>
</c:if>
<c:if test="${!err.equals('')}">
    <span><c:out value="${firstNumber}"></c:out></span>
    <span><c:out value="${operator}"></c:out></span>
    <span><c:out value="${secondNumber}"></c:out></span>
    <span> = </span>
    <span><c:out value="${result}"></c:out></span>
</c:if>
</body>
</html>
