<%@ page import="java.util.List" %>
<%@ page import="model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 11:50 PM
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
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("studentListServlet");
        for(Student student : studentList) {
    %>
    <tr>
    <td></td>
    <td><%=student.getId()%></td>
    <td><%=student.getName()%></td>
    <td><%=student.getDateOfBirth()%></td>
    <td>
            <%if (student.getGender() == 1) { %>
                Male
            <%} else {%>
                Female
            <%}%>
    </td>
    <td><%=student.getGrade()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>