<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<table border="1" style="border-collapse: collapse">
   ${heading}
    <c:forEach items="${cList}" var="i">
        <tr>
            <td>${i.name}</td>
            <td>${i.dateOfBirth}</td>
            <td>${i.address}</td>
            <td><img src="${i.image}" width="50px" height="50px"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>