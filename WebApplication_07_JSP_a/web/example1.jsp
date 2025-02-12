<%-- 
    Document   : example1
    Created on : Feb 12, 2025, 10:32:26 AM
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
        <%! int a = 9;%>
        <%
            double b;
            b = Math.sqrt(a);
        %>
        Kết quả : sqrt(<%= a%>) = <span style="color: red"> <%= b%> </span>;
    </body>
</html>
