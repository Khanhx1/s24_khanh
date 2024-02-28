<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 12/29/2023
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="idEdition" value="${id}">
    <table>
        <tr>
            <th>Edit information</th>
        </tr>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="new id" value="${id}"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="new name"></td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td><input type="number" min="0" name="new quantity"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" min="0"  name="new price"></td>
        </tr>
    </table>
    <br>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
