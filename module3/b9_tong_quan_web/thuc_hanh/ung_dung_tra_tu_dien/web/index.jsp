<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
  <head>
    <title>TranslationServlet</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  <h1>Vietnamese Dictionary</h1>
  <form method="get" action="/translate">
    <input type="text" name="txtSearch" placeholder="Enter your word">
    <input type="submit" id="submit" value="Search">
  </form>
  </body>
</html>
