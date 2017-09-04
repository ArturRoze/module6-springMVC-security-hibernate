<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>all products</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
        <h3>All Products</h3>
        <br>
        <c:if test="${!empty listProducts}">
            <table class="tg">
                <tr>
                    <th width="80">Product ID</th>
                    <th width="100">Product Name</th>
                    <th width="100">Product Cost</th>
                    <th width="100">Description</th>
                    <th width="100">Vendor</th>
                </tr>
                <c:forEach items="${listProducts}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.cost}</td>
                        <td>${product.description}</td>
                        <td>${product.vendor}</td>

                    </tr>
                </c:forEach>
            </table>
        </c:if>
</body>
</html>
