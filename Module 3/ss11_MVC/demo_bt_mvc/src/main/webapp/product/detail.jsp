<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 12/29/2023
  Time: 11:59 AM
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
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>${productDetail.id}</td>
        <td>${productDetail.name}</td>
        <td>${productDetail.quantity}</td>
        <td>${productDetail.price}</td>
    </tr>
</table>
<br>
<a href="/product"><button>Back</button></a>
</body>
</html>
