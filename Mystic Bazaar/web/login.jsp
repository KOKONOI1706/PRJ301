<%-- 
    Document   : login
    Created on : Feb 23, 2025, 11:38:38 AM
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
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="login"/>
            Username: <input type="text" name="username" /><br/>
            Password: <input type="password" name="password"/><br/>
            <input  type="submit" value="Login"/>
        </form>
        <%
            // Lấy giá trị của message và kiểm tra null
            String mess = (String) request.getAttribute("message");
            if (mess != null && !mess.isEmpty()) {
        %>
        <span style="color: red; font-weight: bold;">
            <%= mess%>
        </span>
        <%
            }
        %>

    </body>
</html>
