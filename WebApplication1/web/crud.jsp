<%-- 
    Document   : CRUD Student
    Created on : Jan 22, 2025, 11:20:53 AM
    Author     : GIGABYTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            CRUD Student
        </title>
    </head>
    <body>
        <form action="MainController">
            Full Name: <input type="text" name="name" /> <br/>
            Gender: <input type="radio" name="gender" value="male" checked="checked"/>Male
            <input  type="radio" name="gender" value="Female"/>Female<br/>
            <input type="submit" name="insert" value="Insert"/>
            <input type="submit" name="delete" value="Insert"/>
            <input type="submit" name="update" value="Insert"/>
        </form>
    </body>
</html>
