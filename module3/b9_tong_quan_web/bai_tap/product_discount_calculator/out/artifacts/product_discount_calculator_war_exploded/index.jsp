<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
  <head>
    <title>Discount Servlet</title>
    <link rel="stylesheet" href="./style.css">
  </head>
  <body>
  <form method="post" action="/display-discount">
    <div>
      <lable>Product Description: </lable>
      <input type="text" name="productName">
      <br/>
      <lable>List Price: </lable>
      <input type="text" name="listPrice">
      <br/>
      <lable>Discount Percent: </lable>
      <input type="text" name="discountPercent">
      <br/>
      <input type="submit" id="submit">
    </div>
  </form>
  </body>
</html>
