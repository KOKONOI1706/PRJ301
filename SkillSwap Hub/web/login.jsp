<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="assets/css/normal/login.css"/>

    </head>
    <body>
        <div class="main-contentF">
            <div class="login-container">
                <h2>Login</h2>
                <form action="MainController" method="post">
                    <input type="hidden" name="action" value="login"/>

                    <div class="input-group">
                        <input type="text" name="username" placeholder="Username" required/>
                    </div>

                    <div class="input-group">
                        <input type="password" name="password" placeholder="Password" required/>
                    </div>

                    <button type="submit" class="login-btn">Login</button>
                </form>

                <a href="MainController?action=register" class="register-link">Create an account</a>

                <%
                    String mess = (String) request.getAttribute("message");
                    if (mess != null && !mess.trim().isEmpty()) {
                %>
                <p class="error-message"><%= mess%></p>
                <% }%>
            </div>
        </div>
    </body>

</html>
