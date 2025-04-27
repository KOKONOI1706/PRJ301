<%-- 
Document   : home
Created on : Mar 24, 2025, 4:53:14 PM
Author     : GIGABYTE
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SwapSkill Hub</title>
        <link rel="stylesheet" href="assets/css/normal/home.css"/>

    </head>
    <body>
        
        <%@include file="includes/header.jsp" %> 
        <div class="main-content">
        <% UserDTO user = (UserDTO) request.getSession().getAttribute("user");%>
        <%if (user != null) { %> 
        <div class="welcome-container">
            <% if (user != null) {%>
            <h1>Welcome to SwapSkill Hub, <%= user.getUsername()%>!</h1>
            <% }%>
        </div>
        <% }%>
        <section>
            <h2>Exchange your skill now with SkillSwap Hub!</h2>
            <p>SkillSwap Hub allows you to exchange skills without money. Learn something new and teach others what you know!</p>
        </section>
        </div>
    </body> 
    <%@include file="includes/footer.jsp" %> 
</html>
