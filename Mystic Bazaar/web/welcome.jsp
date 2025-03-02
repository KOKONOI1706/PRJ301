<%-- 
    Document   : welcome
    Created on : Feb 23, 2025, 7:13:56 PM
    Author     : GIGABYTE
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("user") != null) {
                UserDTO user = (UserDTO) session.getAttribute("user");
        %>
        <h1>Hello <%= user.getFullName()%></h1>
        <%}%>
    </body>
</html>
