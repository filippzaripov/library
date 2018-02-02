<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 2/2/2018
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>
    <title>EditBook</title>
</head>
<body>
<form action="saveEditedBook">
    <div class="input-group-addon">
        <span class="input-group-addon">ID</span>
        <input name="id" type="text" class="form-control" placeholder="Id" value="${id}" readonly>
    </div>
    <div class="input-group-addon">
        <span class="input-group-addon">Name</span>
        <input name="name" type="text" class="form-control" placeholder="Name" value="${name}">
    </div>
    <div class="input-group-addon">
        <span class="input-group-addon">Category</span>
        <select name="category">
            <c:forEach items="${categoriesList}" var="category">
                <option><c:out value="${category.getName()}"/></option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group-addon">
        <span class="input-group-addon">Author</span>
        <input name="author" type="text" class="form-control" placeholder="Author" value="${author}">
    </div>
    <input class="btn btn-success" type="submit" value="Save">
    <input class="btn btn-success" type="button" value="Cancel">
</form>
</body>
</html>
