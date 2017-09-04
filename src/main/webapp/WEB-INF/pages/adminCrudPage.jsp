<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <a href="${contextPath}/products/action/create">Create Product</a>
    <br>
    <a href="${contextPath}/products/action/read">Show all Products</a>
    <br>
    <%--TODO: input text - enter id product for updating--%>

    <a href="${contextPath}/products/action/update/1">Update Product</a>
    <br>
    <%--TODO: input text - enter id product for deleting--%>
    <a href="${contextPath}/products/action/delete/1">Delete Product</a>
</body>
</html>
