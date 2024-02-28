<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 27/12/2023
  Time: 10:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Student</h1>
<form action="/student" method="post">
    <input type="hidden" name="action" value="create">
    ID: <input type="text" name="id">
    Name: <input type="text" name="name">
    Point: <input type="text" name="point">
    <button type="submit">Add</button>
</form>
</body>
</html>
