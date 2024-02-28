<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 12/29/2023
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<a href="/product?action=create"><button>Add</button></a>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>

    </tr>
<c:forEach items="${list}" var="student">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td><a href="/product?action=edit&id=${student.id}"><button>Edit</button></a></td>
        <td><a href="/product?action=delete&id=${student.id}"><button>Delete</button></a></td>
        <td><a href="/product?action=detail&id=${student.id}"><button>Detail</button></a></td>
    </tr>


</c:forEach>



</table>
</body>
</html>
