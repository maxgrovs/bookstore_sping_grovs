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
    <title>Add User</title>
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

    <input type="hidden" name="command" value="add_user">

    <label for="input-first-name">First name: </label>
    <input id="input-first-name" type="text" name="firstName" >
    <br>
    <label for="input-last-name">Last name: </label>
    <input id="input-last-name" type="text" name="lastName" >
    <br>
    <input type="submit" value="save">

</form>
</body>
</html>
