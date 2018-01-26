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
            <th>ID</th>
            <th>Title</th>
            <th>Category</th>
            <th>Author</th>
        </tr>
        <c:forEach items="${bookList}" var="books">
            <tr>
                <td><c:out value="${books.id}"/></td>
                <td><c:out value="${books.name}"/></td>
                <td><c:out value="${books.category.getName()}"/></td>
                <td><c:out value="${books.author.getName()}"/></td>
                <td>
                    <form action="delete_book">
                        <button class="btn btn-default btn-lg" type="submit"><span
                                class="glyphicon glyphicon-remove"></span> Delete
                        </button>
                        <input type="hidden" name="ID_to_delete" value="${books.id}">
                    </form>
                </td>
                <td>
                    <form action="#">
                        <button class="btn btn-default btn-lg" type="submit"><span
                                class="glyphicon glyphicon-edit"></span> Edit
                        </button>
                        <input type="hidden">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<H3>Please enter id to find book</H3>
<form action="find_book_by_id" method="get">
    <input type="number" name="id" min="1" max="9223372036854775807" value="book id"
           onfocus="if (this.value == 'book id') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'book id';}"/>
    <input type="submit" value="FIND BOOK"/>
</form>
<H3>Please fill this form to add new book</H3>
<form action="add_book">
    <input type="text" name="name" value="name of the book"
           onfocus="if (this.value == 'name of the book') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'name of the book';}"/>
    <input type="text" name="author" value="author" onfocus="if (this.value == 'author') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'author';}"/>
    <input type="text" name="categoryName" value="book category"
           onfocus="if (this.value == 'book category') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'book category';}"/>
    <input type="submit" value="ADD BOOK"/>
</form>
<H3>Please enter id of the book that you want to delete</H3>
<form action="delete_book">
    <input type="number" name="ID_to_delete" min="1" max="9223372036854775807" value="book id"
           onfocus="if (this.value == 'book id') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'book id';}"/>
    <input type="submit" value="DELETE BOOK"/>
</form>
<div><c:out value="${result}"/></div>


</body>
</html>
