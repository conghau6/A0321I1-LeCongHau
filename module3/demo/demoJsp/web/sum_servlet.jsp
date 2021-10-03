<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/1/2021
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Cách 2--%>
<%
    String a = request.getParameter("number1");
    String b = request.getParameter("number2");
    int c = Integer.parseInt(a) + Integer.parseInt(b);
%>
<h2 style="color: blue"><%=c%></h2>
</body>
</html>
