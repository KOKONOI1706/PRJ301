<%-- 
    Document   : header
    Created on : Mar 26, 2025, 10:02:55 AM
    Author     : GIGABYTE
--%>

<%@page import="dto.NotificationDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.NotificationDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.UserDTO"%>
<%
    UserDTO sessionUser = (UserDTO) request.getSession().getAttribute("user");
    boolean isLoggedIn = (sessionUser != null);
%>
<%
    NotificationDAO notificationDAO = new NotificationDAO();
    List<NotificationDTO> notifications = sessionUser != null ? notificationDAO.getNotificationsByUserId(sessionUser.getUser_id()) : null;
%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/normal/header.css">

</head>

<div class="header">
    <div class="nav-container">
        <h2 class="logo">SkillSwap Hub</h2>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="viewSwapRequests.jsp">Swap Requests</a></li>
                    <%
                        if (sessionUser != null) {
                    %>
                <li><a href="userProfile.jsp?userId=<%= isLoggedIn ? sessionUser.getUser_id() : 0%>">My Profile</a></li>
                    <%}%>
            </ul>
        </nav>
        <form action="SearchSkillController" method="post" class="search-form">
            <input type="hidden" name="category" value=""/> 
            <input type="text" name="keyword" placeholder="Search skills">
            <button type="submit">Search</button>
        </form>
        <% if (notifications != null && !notifications.isEmpty()) {%>
        <div class="notifications">
            <button class="notif-btn">Notifications (<%= notifications.size()%>)</button>
            <div class="notif-dropdown">
                <% for (NotificationDTO notif : notifications) {%>
                <p><%= notif.getMessage()%></p>
                <% } %>
            </div>
        </div>
        <% } %>
        <div class="user-actions">
            <% if (isLoggedIn) { %>
            <a href="MainController?action=logout" class="logout-btn">Logout</a>
            <% } else { %>
            <a href="login.jsp" class="login-btn">Login</a>
            <% }%>
        </div>
    </div>
        <script>
    
</script>

</div>
