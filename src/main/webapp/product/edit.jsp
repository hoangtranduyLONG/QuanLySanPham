<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25/05/2022
  Time: 8:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <input type="number" name="id" value="${spCanSua.id}">
    <input type="text" name="name" value="${spCanSua.name}">
    <input type="number" name="price" value="${spCanSua.price}">
    <input type="text" name="description" value="${spCanSua.description}">
    <input type="text" name="producer" value="${spCanSua.producer}">
    <button>Sua</button>
</form>
</body>
</html>
