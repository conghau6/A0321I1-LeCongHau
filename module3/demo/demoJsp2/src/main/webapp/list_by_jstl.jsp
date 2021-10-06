<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2021
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Gender</th>
        <th>Degree</th>
    </tr>
<c:forEach var="student" items="${studentListServlet}" varStatus="loop">
    <tr>
        <td>${loop.count}</td>
        <td><c:out value="${student.id}"></c:out></td>
        <td><c:out value="${student.name}"></c:out></td>
        <td><c:out value="${student.dateOfBirth}"></c:out></td>
        <td>
            <c:if test="${student.gender == 1}">
                <c:out value="Male"></c:out>
            </c:if>
            <c:if test="${student.gender == 0}">
                <c:out value="Female"></c:out>
            </c:if>
        </td>
        <td>
            <c:choose>
                <c:when test="${student.grade < 4}">
                    <c:out value="Bad"></c:out>
                </c:when>
                <c:when test="${student.grade < 7}">
                    <c:out value="Good"></c:out>
                </c:when>
                <c:otherwise>
                    <c:out value="Very Good"></c:out>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
