<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 1/11/2024
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator/calculate" method="post">
    <input type="number" name="first" value="${first}">&nbsp&nbsp<input type="number" name="second" value="${second}"><br>
    <button type="submit" name="function" value="addition">Addition(+)</button>&nbsp
    <button type="submit" name="function" value="subtraction">Subtraction(-)</button>&nbsp
    <button type="submit" name="function" value="multiplication">Multiplication(X)</button>&nbsp
    <button type="submit" name="function" value="division">Division(/)</button>&nbsp
</form>
Result ${function}: ${result}
</body>
</html>
