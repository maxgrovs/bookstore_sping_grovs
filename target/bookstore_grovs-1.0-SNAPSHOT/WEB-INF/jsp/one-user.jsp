<jsp:useBean id="user" scope="request" type="by.grovs.entity.User"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User List</title>
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

<h1>User </h1>
<table>

    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Password</th>

    </tr>

    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.password}</td>

        <td>

        </td>
    </tr>


</table>

<a href="book-store?command=update_user_form&id=${user.id}">Edit</a>

</body>
</html>
