<%-- 
    Document   : example3
    Created on : Feb 12, 2025, 10:45:11 AM
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
        <% for (int i = 2; i <= 9; i++) {%>
        <hr/>
        <h1>Bảng Cửu Chương <%=i%></h1>
        <%for (int j = 1; j <= 10; j++) {%>
        <%=i%> * <%=j%> = <%=i * j%> <br/>
        <%
                }
            }
        %>
    </body>
</html >
