<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 2/7/2018
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.0.0/css/bootstrap.min.css'>
    <script type='text/javascript' src='${pageContext.request.contextPath}/webjars/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/webjars/bootstrap/4.0.0/js/bootstrap.min.js'></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myScripts.js"></script>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/css/myCss.css'/>
    <base href="/library-webapp/"/>
    <meta contentType="text/html; charset=UTF-8"/>
    <title>EditBook</title>
</head>
<body>


<div class="container" id="editBookForm">
    <div>
        <div class="alert alert-success" style="${displayEditBookAlert}"><c:out value="${resultEdit}"/></div>
        <div class="alert alert-danger" style="${displayErrorEditBookAlert}"><c:out value="${resultError}"/></div>
    </div>
    <form class="createOrEditBook" action="saveEditedBook" method="post">
        <h2 class="h2"><c:out value="${title}"/></h2>
            <div class="input-group-addon" style="${displayId}">
                <span class="input-group-addon">ID</span>
                <input name="id" type="text" class="form-control" placeholder="Id" value="${id}" readonly>
            </div>

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
            <input id="saveButton" class="btn btn-success" type="submit" value="${saveType}">
            <a id="cancelButton" href="main" class="btn btn-warning" type="button">Back to Library</a>
    </form>
</div>
</body>
</html>