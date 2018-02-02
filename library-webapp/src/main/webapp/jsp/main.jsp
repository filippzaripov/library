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

    <script>
       /* $(".btn[data-target='#myModal']").click(function() {
            var columnHeadings = $("thead th").map(function() {
                return $(this).text();
            }).get();
            columnHeadings.pop();
            var columnValues = $(this).parent().siblings().map(function() {
                return $(this).text();
            }).get();
            var modalBody = $('<div id="modalContent"></div>');
            var modalForm = $('<form role="form" name="modalForm" action="test" method="post"></form>');
            $.each(columnHeadings, function(i, columnHeader) {
                var formGroup = $('<div class="form-group"></div>');
                formGroup.append('<label for="'+columnHeader+'">'+columnHeader+'</label>');
                formGroup.append('<input class="form-control" name="'+columnHeader+i+'" id="'+columnHeader+i+'" value="'+columnValues[i]+'" />');
                modalForm.append(formGroup);
            });
            modalBody.append(modalForm);
            $('.modal-body').html(modalBody);
        });
        $('.modal-footer .btn-primary').click(function() {
            $('form[name="modalForm"]').submit();
        });*/
    </script>

</head>
<body>

<h1 class="page-header">Library</h1>

<div class="modal fade" id="editDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content"></div>
    </div>
    <div class="modal-dialog">
        <div class="modal-content"></div>
    </div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true" class="">X</span>
                    <span class="sr-only">Close</span>

                </button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>

            </div>
            <div class="modal-body">
                <div class="input-group">
                    <input type="text" class="input" name="id" id="idModal"/><br>
                    <input type="text" class="input" name="name" id="nameModal"/><br>
                    <input type="text" class="input" name="category" id="categoryModal"/><br>
                    <input type="text" class="input" name="author" id="authorModal"/><br>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="panel panel-primary">
    <table class="table table-bordered">
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
                <%--<td><a onclick="getElementById('editBookWindow').removeAttribute('style')" name="editBookField">
                    Edit </a></td>
                <td><a href="#myModal" class="btn btn-primary" data-toggle="modal"> Modal </a></td>--%>
                <td>
                    <a href="editBook?editBookId=${book.id}"> Edit </a><br>
                    <a href="delete_book?ID_to_delete=${book.id}" name="deleteBookField"> Delete </a>
                </td>

                    <%--<td>
                        <form action="delete_book">
                            <button class="btn btn-default btn-lg" type="submit"><span
                                    class="glyphicon glyphicon-remove"></span> Delete
                            </button>
                            <input type="hidden" name="ID_to_delete" value="${books.id}">
                        </form>
                    </td>--%>
            </tr>
        </c:forEach>
        </tbody>
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
<form action="add_book" method="get">
    <input type="text" name="name" value="name of the book"
           onfocus="if (this.value == 'name of the book') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'name of the book';}"/>
    <input type="text" name="author" value="author" onfocus="if (this.value == 'author') {this.value = '';}"
           onblur="if (this.value == '') {this.value = 'author';}"/>
    <select name="category">
        <c:forEach items="${categoriesList}" var="category">
            <option><c:out value="${category.getName()}"/></option>
        </c:forEach>
    </select>

    <input type="submit" value="ADD BOOK"/>
</form>

<div><c:out value="${result}"/></div>


</body>
</html>
