
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order List</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h1>All Orders </h1>
<table>

    <tr>

        <th>ID</th>
        <th>User</th>
        <th>Items</th>
        <th>Status</th>

    </tr>



    <%--@elvariable id="orders" type="java.util.List"--%>
    <%--@elvariable id="order" type="by.grovs.entity.Order"--%>
    <c:forEach var="order" items="${orders}" varStatus="status" step="1">
        <tr>

            <td>${order.id}</td>
            <td>${order.user.firstName}</td>
            <td></td>
            <td>${order.status.name()}</td>

        </tr>
    </c:forEach>



</table>

<%--<a href="book-store?command=update_user_form&id=${order.id}">Edit</a>--%>

</body>
</html>
