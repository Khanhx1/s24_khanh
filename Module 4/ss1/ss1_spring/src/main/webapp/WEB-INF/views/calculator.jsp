<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 1/10/2024
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator/calculate" method="get">
<table>
    <tr>
        <td>Nhap so tien (USD)</td>
        <td><input type="number" min="0" name="usd"></td>
        <td>Nhap ty gia</td>
        <td><input type="number" min="0" name="rate"></td>
    </tr>
    <tr>
        <td><button>Tinh</button></td>
        <td>${result}</td>
    </tr>
</table>
</form>
</body>
</html>
