

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
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="jquery.tabledit.js"></script>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="css/myCss.css" rel="stylesheet">
    <script>
        $(document).on("click", "#welcome_button", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("test", function(responseJson) {
                var $table = $("<table>").appendTo($("#testJson")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
                $.each(responseJson, function(index, book) { // Iterate over the JSON array.
                    $("<tr>").appendTo($table)
                        .append($("<td>")).text(book.id)
                        .append($("<td>")).text(book.name)
                        .append($("<td>")).text(book.category.name)
                        .append($("<td>")).text(book.author.name)
                });
            });
        });
    </script>
</head>
<body>
<button id="welcome_button">press here</button>
<div id="testJson"></div>


</body>
</html>
