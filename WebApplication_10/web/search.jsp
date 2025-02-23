<%-- 
    Document   : user
    Created on : Feb 13, 2025, 8:49:59 AM
    Author     : tungi
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
        <h1>Welcome <%=user.getFullName()%> </h1>
        <hr/>
        <form action="MainController" method="get">
            <input type="hidden" name="action" value="logout"/>
            <input type="submit" value="Logout"/>
        </form>
        
        <form action="MainController" method="get">
            <input type="hidden" name="action" value="search"/>
            Search books:<input type="text" name="searchTerm" />
            <input type="submit" value="Search"/>
        </form>
        
        <%} else {%>
        You do not have permission to access this content
        <%}%>
    </body>
</html>