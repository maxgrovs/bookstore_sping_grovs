<jsp:useBean id="order" scope="request" type="by.grovs.entity.Order"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<h1>Order </h1>
<table>
    <%

    %>
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Items</th>
        <th>Status</th>
    </tr>

    <tr>
        <td>${order.id}</td>
        <td>${order.user.firstName}</td>
<%--        <td>${order.author}</td>--%>
<%--        <td>${order.date}</td>--%>
<%--        <td>${order.cost} $</td>--%>

        <td>

        </td>
    </tr>


</table>

<a href="book-store?command=update_book_form&id=${order.id}">Edit</a>

</body>
</html>
