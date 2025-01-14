<%-- 
    Document   : login
    Created on : Jan 14, 2025, 4:36:32 PM
    Author     : GIGABYTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <form action="LoginServlet" method="POST">
            <table>
                <tr colspan="colspan"> User Information</tr>
                <tr>
                    <td>Student Id: <input type="text" name="id" required=""/></td>
                </tr>
                <tr>
                    <td>Fullname: <input type="text" name="name" required=""/></td>
                </tr>
                <tr>
                    <td>
                        Gender: 
                        <input type="radio" name="gender" value="male" checked="checked"/> Male
                        <input type="radio" name="gender" value="female"/> Female<br/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
