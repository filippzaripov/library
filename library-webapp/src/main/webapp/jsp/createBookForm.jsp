
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link rel='stylesheet' href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <title>CreateBook</title>
</head>
<body>
<form action="newBook" method="get">
    <div class="input-group-addon">
        <span class="input-group-addon">Name</span>
        <input name="name" type="text" class="form-control" placeholder="Name" value="${name}" required>
    </div>
    <div class="input-group-addon">
        <span class="input-group-addon">Category</span>
        <select class="form-control" name="category">
            <c:forEach items="${categoriesList}" var="category">
                <option><c:out value="${category.getName()}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="input-group-addon">
        <span class="input-group-addon">Author</span>
        <input name="author" type="text" class="form-control" placeholder="Author" value="${author}" required>
    </div>
    <input class="btn btn-success" type="submit" value="Create Book">
    <a href="main" class="btn btn-warning" type="button">Back to Library</a>
</form>
<div class="alert alert-success"><c:out value="${result}"/></div>
</body>
</html>
