<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 1/2/2024
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <form action="/users" method="get">
            <input type="hidden" name="action" value="search">
            <input type="text" name="search"><button type="submit">tim kiem</button>
        </form>

        <form action="/users" method="get">
            <input type="hidden" name="action" value="order">

        <select name="orderOption">
            <option value="asc">Tang dan</option>
            <option value="desc">Giam dan</option>
        </select>
            <button type="submit">Sap xep</button>
        </form>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
