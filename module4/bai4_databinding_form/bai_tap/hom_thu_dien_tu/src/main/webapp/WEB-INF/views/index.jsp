<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2021
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form modelAttribute="emailConfig" method="post" acction="/submit">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="language" items="${listLanguages}"/>
<%--                    <c:forEach items="${listLanguages}" var="language">--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${language == emailConfig.language}">--%>
<%--                                <form:option selected="true" value="${language}">${language}</form:option>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <form:option value="${language}">${language}</form:option>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                    </c:forEach>--%>
            </td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>
                <span>Show </span>
                <form:select path="pageSize" items="${listPageSize}"/>
                <span> emails per page</span>
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:checkbox path="spamFilter"/> Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="button" value="Cancel"></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>