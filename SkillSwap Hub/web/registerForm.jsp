<%-- 
    Document   : registerForm
    Created on : Mar 24, 2025, 12:04:31 PM
    Author     : GIGABYTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register - SwapSkill Hub</title>
        <link rel="stylesheet" type="text/css" href="assets/css/normal/registerForm.css">
        <%@include file="includes/header.jsp" %> 
    </head>
    <body>
        <div class="register-container">
            <h2>Register at SwapSkill Hub</h2>
            <form action="RegisterController" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required />

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required />

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required />

                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required />

                <button type="submit">Register</button>
            </form>

            <p>Already have an account? <a href="login.jsp" class="login-link">Login here</a></p>

            <%
                String mess = request.getAttribute("message") + "";
                mess = mess.equals("null") ? "" : mess;
            %>
            <span class="error"><%= mess%></span>
        </div>
        <%@include file="includes/footer.jsp" %> 
    </body>
</html>
