<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/display-discount " method="post">
    <div class="input-info">
        <h2>Product Discount Calculator</h2>
        <p>Product description</p><input type="text" name="product description" size="30" placeholder="product description" />
        <p>List Price</p><input type="number" min="0" name="list price" size="30" placeholder="list Price" />
        <p>Discount Percent</p><input type="number" min="0" name="discount percent" placeholder="discount percent"/><br><br>
        <input type="submit" value="calculator">
    </div>
</form>
</body>
</html>