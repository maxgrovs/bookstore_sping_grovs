<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body> //book-store?command=update-book&id=5&name=Valera
<form method="post" action="controller">

    <input type="hidden" name="command" value="update-book">
    <input type="hidden" name="id" value="${requestScope.user.id}">
    <label for="input-name">Name: </label>
    <input id="input-name" type="text" name="name" value="${requestScope.user.name}">
    <br>
    <input type="submit" value="save">

</form>
</body>
</html>
