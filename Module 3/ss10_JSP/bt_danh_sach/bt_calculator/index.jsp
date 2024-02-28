<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action="/a" method="post">
    <div class="calculator">
        First operand: &nbsp&nbsp <input type="number" name="first operand"><br>
        <select name="operator">
            <option value="add">Addition</option>
            <option value="minus">Subtraction</option>
            <option value="multiplication">Multiplication</option>
            <option value="division">Division</option>
        </select><br>
        Second operand: &nbsp&nbsp <input type="number" name="second operand"><br>
    </div>
    <button type="submit">calculate</button>
</form>
<p>Result: ${result}</p>
<p>${message}</p>
</body>
</html>