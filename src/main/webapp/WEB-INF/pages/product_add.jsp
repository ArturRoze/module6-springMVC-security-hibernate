<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<div>
    <form action="/products/create/" method="post">
        <table align="center">
            <tr>
                <th>Enter name of product</th>
                <td>
                    <input autofocus type="text" name="name">
                </td>
            </tr>
            <tr>
                <th>Enter vendor</th>
                <td>
                    <input type="text" name="vendor">
                </td>
            </tr>
            <tr>
                <th>Enter cost</th>
                <td><input type="number" name="dollars">dollars
                    <input type="number" name="cents" maxlength="2">cents</td>
            </tr>
            <tr>
                <th>Enter description</th>
                <td>
                    <input type="text" name="description">
                </td>
            </tr>
            <tr>
                <td align="center">
                    <button type="submit">Enter</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
