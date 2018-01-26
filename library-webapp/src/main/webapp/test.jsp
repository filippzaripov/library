<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 12/26/2017
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"
>
<head>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>

    <title>Books</title>
    <meta charset="UTF-8">

</head>
<body>
    <h1 class="page-header">Library</h1>
    <div class="panel panel-primary">
        <table class="table table-responsive">
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Category</th>
                    <th>Author</th>
                </tr>
                <c:forEach items="${bookList}" var="books">
                    <tr>
                        <td><c:out value="${books.id}"/> </td>
                        <td><c:out value="${books.name}"/></td>
                        <td><c:out value="${books.category.getName()}"/></td>
                        <td><c:out value="${books.author.getName()}"/></td>
                    </tr>
                </c:forEach>
        </table>
    </div>
</body>
</html>
