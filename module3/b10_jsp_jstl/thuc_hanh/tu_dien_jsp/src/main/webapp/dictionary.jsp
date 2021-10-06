<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2021
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>
<%
    dic.put("hello","xin chào");
    dic.put("good bye", "tạm biệt");
    String search = request.getParameter("search");
    String result = dic.get(search);
    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    if(result!=null){
        writer.println("word: " + search + "<br/>");
        writer.println("result: " + result);
    } else {
        writer.println("Not found");
    }
    writer.println("</html>");
%>
</body>
</html>
