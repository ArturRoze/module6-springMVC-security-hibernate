<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<sec:authorize access="hasRole('ADMIN')">
    <a href="${contextPath}/products/action/create">Create Product</a>
    <br>

    <%--TODO: input text - enter id product for updating--%>

    <a href="${contextPath}/products/action/update/1">Update Product</a>
    <br>
    <%--TODO: input text - enter id product for deleting--%>
    <a href="${contextPath}/products/action/delete/1">Delete Product</a>
    <br>
</sec:authorize>

<sec:authorize access="hasAnyRole('USER', 'ADMIN')">

    <a href="${contextPath}/products/action/read">Show all Products</a>
</sec:authorize>
</body>
</html>
