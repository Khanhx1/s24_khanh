<%--
  Created by IntelliJ IDEA.
  User: Khanh
  Date: 1/12/2024
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form action="/mail/save" method="post" modelAttribute="mailConfig">
    <table>
        <tr>
            <td>Language</td>
            <td><form:select path="language">
                <form:options items="${languages}"></form:options>
            </form:select></td>
        </tr>

        <tr>
            <td>Page size</td>
            <td>Show&nbsp<form:select path="pageSize">
                <form:options items="${size}"></form:options>
            </form:select>&nbspEmails&nbspper&nbsppage</td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td><form:checkbox path="spamFilter"></form:checkbox>&nbspEnable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td><button type="submit">update</button></td>
            <td><button>cancel</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
