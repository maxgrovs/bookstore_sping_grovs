<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add book</title>
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

<%--/book-store?command=update-book&id=5&name=Valera--%>

<body>
<form method="post" action="book-store">

    <input type="hidden" name="command" value="add_book">

    <label for="input-title">Title: </label>
    <input id="input-title" type="text" name="title" >
    <br>
    <label for="input-author">Author: </label>
    <input id="input-author" type="text" name="author" >
    <br>
    <input type="submit" value="save">

</form>
</body>
</html>
