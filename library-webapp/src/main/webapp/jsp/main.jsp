<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 12/26/2017
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script type="text/javascript" src="js/filterTable.js"></script>
    <script type="text/javascript" src="js/tablesorter.js"></script>

    <title>Books</title>
    <meta charset="UTF-8">

</head>
<body>

<h1 class="page-header">Library</h1>
<nav class="navbar navbar-light bg-light">
    <a class="btn btn-success" href="createBook">Add Book</a>
    <form class="form-inline">
        <input class="form-control" id="searchInput" onkeyup="filterTable()" type="search" placeholder="Search" aria-label="Search">
    </form>
    </div>
</nav>


<div class="panel panel-primary">
    <table id="mainTable" class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Category</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookList}" var="book">
            <tr id="R<c:out value="${book.id}"/>">
                <td class="id"><c:out value="${book.id}"/></td>
                <td class="name"><c:out value="${book.name}"/></td>
                <td class="category"><c:out value="${book.category.getName()}"/></td>
                <td class="author"><c:out value="${book.author.getName()}"/></td>
                <td>
                    <a href="editBook?editBookId=${book.id}"> Edit </a><br>
                    <a href="delete_book?ID_to_delete=${book.id}" name="deleteBookField"> Delete </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="alert-warning"><c:out value="${result}"/></div>


</body>
</html>
