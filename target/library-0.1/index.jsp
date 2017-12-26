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
    <H3>Please enter id to find book</H3>
    <form action="book_by_id" method="get">
        <input type="text" name="ID" value="Please enter book ID" onfocus="if (this.value == 'Please enter book ID') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Please enter book ID';}"/>
        <input type="submit" value="FIND BOOK"/>
    </form>
    <H3>Please click this button to show all books</H3>
    <form action="all_books">
        <input type="submit" value="SHOW ALL BOOKS"/>
    </form>

    <div><c:out value="${result}"/></div>

</body>
</html>
