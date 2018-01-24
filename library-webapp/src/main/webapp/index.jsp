<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 12/26/2017
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
<head>
    <title>Books</title>
    <meta charset="UTF-8">

</head>
<body>
    <table border="1px" class="book-table" align="right">
        <tr>
            <th>ID</th>
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
    <H3>Please enter id to find book</H3>
    <form action="find_book_by_id" method="get">
        <input type="number" name="id" min="1" max="9223372036854775807" value="book id" onfocus="if (this.value == 'book id') {this.value = '';}" onblur="if (this.value == '') {this.value = 'book id';}"/>
        <input type="submit" value="FIND BOOK"/>
    </form>
    <H3>Please click this button to show all books</H3>
    <form action="show_all_books">
        <input type="submit" value="SHOW ALL BOOKS"/>
    </form>
    <H3>Please fill this form to add new book</H3>
    <form action="add_book">
        <input type="text" name="name" value="name of the book" onfocus="if (this.value == 'name of the book') {this.value = '';}" onblur="if (this.value == '') {this.value = 'name of the book';}"/>
        <input type="text" name="author" value="author"onfocus="if (this.value == 'author') {this.value = '';}" onblur="if (this.value == '') {this.value = 'author';}"/>
        <input type="text" name="categoryName" value="book category" onfocus="if (this.value == 'book category') {this.value = '';}" onblur="if (this.value == '') {this.value = 'book category';}"/>
        <input type="submit" value="ADD BOOK"/>
    </form>
    <H3>Please enter id of the book that you want to delete</H3>
    <form action="delete_book">
        <input type="number" name="ID_to_delete" min="1" max="9223372036854775807" value="book id" onfocus="if (this.value == 'book id') {this.value = '';}" onblur="if (this.value == '') {this.value = 'book id';}"/>
        <input type="submit" value="DELETE BOOK"/>
    </form>
    <div><c:out value="${result}"/></div>


</body>
</html>
