<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/1/2021
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Cách 3--%>
<h2 style="color: #8dff2c;">${resultFormServlet}</h2>
<h2 style="color: blue">
    <%=request.getAttribute("resultFormServlet")%>
</h2>
</body>
</html>
