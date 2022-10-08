<%@ page import="by.grovs.entity.Book" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%

%>


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

<h1>Book List</h1>

<table>

    <tr>
        <th>Title</th>
        <th>Author</th>
    </tr>


    <c:forEach var="book" items="${books}" varStatus="status" step="1">
        <tr>

            <td>
                <a href="${pageContext.request.contextPath}book-store?command=book&id=${book.id}"> ${book.name}</a>
            </td>
            <td>${book.author}</td>


            <td>

            </td>
        </tr>
    </c:forEach>


</table>

<h2>
    <a href="book-store?command=add_book_form">Add</a>
</h2>

<h2><a href="book-store">Beck to main page</a></h2>
</body>
</html>
