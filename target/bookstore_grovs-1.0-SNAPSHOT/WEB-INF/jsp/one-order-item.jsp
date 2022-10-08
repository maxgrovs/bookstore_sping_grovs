<%--@elvariable id="item" type="by.grovs.entity.OrderItem"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>


<head>
    <title>Items List</title>
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

<h1>Item </h1>
<table>
    <%

    %>
    <tr>
        <th>ID</th>
        <th>Book</th>

    </tr>

    <tr>
        <td>${item.id}</td>
        <td>${item.book.name}</td>


    </tr>


</table>

<%--<a href="book-store?command=update_book_form&id=${order.id}">Edit</a>--%>

</body>
</html>
