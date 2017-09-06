<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<sec:authorize access="hasRole('ADMIN')">
    <a href="${contextPath}/products/create">Create Product</a>
</sec:authorize>

<sec:authorize access="hasAnyRole('USER', 'ADMIN')">
    <a href="${contextPath}/products/read">Show all Products</a>
</sec:authorize>
</body>
</html>
