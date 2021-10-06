<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/3/2021
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
  <h2>Currency Convert</h2>
  <form method="post" action="/convert">
    <lable>Rate: </lable><br/>
    <input type="number" name="rate" placeholder="RATE" value="22000"><br/>
    <lable>USD: </lable><br/>
    <input type="number" name="usd" placeholder="USD" value="0"><br/>
    <input type="submit" name="submit" id="submit">
  </form>
  </body>
</html>
