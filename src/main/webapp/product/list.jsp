<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25/05/2022
  Time: 8:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach san pham</h1>
<a href="/products?action=create">Tao moi san pham</a>
<c:forEach items ='${danhSach}' var="sanPham">
    <h3>${sanPham.id}, ${sanPham.name},
            ${sanPham.price}, ${sanPham.description},
            ${sanPham.producer}  <a href="/products?action=edit&id=${sanPham.id}">Sua</a>
        <a href="/products?action=delete&id=${sanPham.id}">Xoa</a></h3>
</c:forEach>
</body>
</html>
