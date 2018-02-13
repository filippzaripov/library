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
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.0.0/css/bootstrap.min.css'>
    <script type='text/javascript' src='${pageContext.request.contextPath}/webjars/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/webjars/bootstrap/4.0.0/js/bootstrap.min.js'></script>
    <script type="text/javascript" src="js/filterTable.js"></script>
    <script type="text/javascript" src="js/tablesorter.js"></script>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/css/myCss.css'/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myScripts.js"></script>
    <title>Books</title>
    <base href="/library-webapp/main/">
    <meta charset="UTF-8">

</head>
<body>

<div id="mainCentral">
    <h1 class="page-header">Library</h1>
    <div id="mainTableAlert" class="alert alert-success" style="display: none;"><c:out value="${result}"/></div>
    <nav class="navbar navbar-light">
        <a class="btn btn-success" href="createBook">Add Book</a>
        <form  class="form-inline">
            <input  class="form-control" id="searchInput" onkeyup="filterTable()" type="search" placeholder="Search" aria-label="Search" style="margin-top: 6px;">
        </form>
    </nav>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
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
                        <a id="deletedBook" href="delete_book?ID_to_delete=${book.id}" name="deleteBookField"> Delete </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
