<jsp:useBean id="book" scope="request" type="by.grovs.entity.Book"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>


<head>
    <title>Book List</title>
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

<h1>Book </h1>
<table>
    <%

    %>
    <tr>
        <th>Isbn</th>
        <th>Title</th>
        <th>Author</th>
        <th>Date of publication</th>
        <th>Cost</th>
    </tr>

    <tr>
        <td>${book.isbn}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.date}</td>
        <td>${book.cost} $</td>

        <td>

        </td>
    </tr>


</table>

<a href="book-store?command=update_book_form&id=${book.id}">Edit</a>
<a href="book-store?command=delete_book&id=${book.id}">Delete</a>

</body>
</html>
