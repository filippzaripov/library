<%--
  Created by IntelliJ IDEA.
  User: Phil
  Date: 1/31/2018
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' href='webjars/bootstrap/4.0.0/css/bootstrap.min.css'>
    <script type='text/javascript' src='webjars/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript' src='webjars/bootstrap/4.0.0/js/bootstrap.min.js'></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myScripts.js"></script>
    <title>Library</title>
</head>
<body>
   <% response.sendRedirect(request.getContextPath()+"/main/books?page=1");%>
</html>
