<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 27/12/2023
  Time: 10:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${g}</div>
<div>${p}</div>
<a href="/student?action=create">Add new Student</a>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Point</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.point}</td>
            <td>
                <a href="/student?action=edit&id=${student.id}">Edit</a>
            </td>
            <td>
                <button>Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
