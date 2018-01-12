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

    <table border="1px" class="book-table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
        </tr>

        <c:forEach items="${bookList}" var="books">
            <tr>
                <td><c:out value="${books.id}"/> </td>
                <td><c:out value="${books.name}"/></td>
                <td><c:out value="${books.category_name}"/></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
