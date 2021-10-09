<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2021
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student by JSTL</title>
</head>
<body>
<h2>List student by JSTL</h2>
<table>
    <tr>
        <th>NO</th>
        <th>ID</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th>Gender</th>
        <th>Degree</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="student" items="${studentListServlet}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${student.id}"></c:out></td>
            <td><c:out value="${student.name}"></c:out></td>
            <td>${student.dateOfBirth}</td>
            <td>
                <c:if test="${student.gender == 1}">Male</c:if>
                <c:if test="${student.gender == 0}">Female</c:if>
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.grade <4}">Bad</c:when>
                    <c:when test="${student.grade <7}">Good</c:when>
                    <c:otherwise>Very good</c:otherwise>
                </c:choose>
            </td>
            <td><a href="/student?action=update&id=${student.id}">Edit</a> </td>
            <td><a href="/student?action=delete&id=${student.id}">Edit</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
