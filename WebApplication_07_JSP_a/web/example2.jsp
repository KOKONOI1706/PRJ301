<%-- 
    Document   : example2
    Created on : Feb 12, 2025, 10:38:45 AM
    Author     : GIGABYTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% for (int i = 0; i <= 100; i++) {%>

        <b style="color: blue"><%=i%></b> <br/>
        <% }
        %>

    </body>
</html>
