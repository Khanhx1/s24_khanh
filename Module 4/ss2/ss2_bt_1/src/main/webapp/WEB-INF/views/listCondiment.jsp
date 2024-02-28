<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 1/11/2024
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich condiments</h2>
<form action="condiment/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">lettuce&nbsp
    <input type="checkbox" name="condiment" value="tomato">tomato&nbsp
    <input type="checkbox" name="condiment" value="mustard">mustard&nbsp
    <input type="checkbox" name="condiment" value="sprouts">sprouts&nbsp
    <br>
    <button type="submit">save</button>
</form>
<div>Saved condiment:</div>
<div>
    <c:forEach items="${result}" var="condiment">
        ${condiment} ,
    </c:forEach>
</div>

</body>
</html>
