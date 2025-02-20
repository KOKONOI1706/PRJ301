<%-- 
    Document   : login
    Created on : Feb 13, 2025, 8:13:53 AM
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
        <jsp:include page="header.jsp"/>
        <div style="min-height: 800px">
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="login"/>
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/><br/>
            <input type="submit" value="Submit"/>
        </form>
            
        <%
            String mess = request.getAttribute("message") + "";
        %>
        <%= mess.equals("null") ? "" : mess%>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
