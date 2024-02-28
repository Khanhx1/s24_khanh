<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 1/11/2024
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary/translate">
    <table>
        <tr>
            <td>Nhập từ cần dịch</td>
            <td><input type="text" name="eng" value="${resultENG}"></td>
        </tr>
        <tr>
            <td><button type="submit">Dịch</button></td>
            <td>${resultVN}</td>
        </tr>
    </table>
</form>
</body>
</html>
