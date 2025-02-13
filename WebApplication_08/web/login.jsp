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
        <form action="MainController" >
            <input type="hidden" name="action" value="login"/>
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/><br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
