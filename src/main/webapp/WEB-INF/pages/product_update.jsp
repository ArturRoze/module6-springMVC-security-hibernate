<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update product</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<div align="center">
    <form action="/products/update" method="post">
        <input name="id" value="${product.id}" hidden>
        <table border="bold" id="products">
            <tr>
                <th></th>
                <th>Old product</th>
                <th>New product</th>
            </tr>
            <tr>
                <td>Name</td>
                <td>${product.name}</td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Vendor</td>
                <td>${product.vendor}</td>
                <td><input type="text" name="vendor" value="${product.vendor}"></td>
            </tr>
            </tr><tr>
            <td>Cost</td>
            <td>${product.cost}</td>
            <td><input type="number" name="dollars" value="${product.cost.intValue()}">dollars
                <input type="number" name="cents" value="${product.cost.subtract(product.cost.intValue())*100}", maxlength="2">cents</td>
        </tr>
            <tr>
                <td>Description</td>
                <td>${product.description}</td>
                <td><input type="text" name="description" value="${product.description}"></td>
            </tr>
            <tr>
                <th><input type="submit" value="Update"></th>
                <th><input type="reset" name="Reset"></th>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
