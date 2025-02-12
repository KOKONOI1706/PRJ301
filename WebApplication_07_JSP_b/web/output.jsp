<%-- 
    Document   : output
    Created on : Feb 12, 2025, 10:58:33 AM
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
           <%
            int n = (int)request.getAttribute("n");
        %>
        <h3>BẢNG CỬU CHƯƠNG <%=n%></h3>
        <%
            for(int i=1; i<=10; i++){
        %>
            <%=n%> * <%=i%> = <%=(i*n)%><br/>
        <%
            }
        %>
        <a href="input.jsp">Input again</a>
    </body>
</html>
