<%-- 
    Document   : userProfile
    Created on : Mar 26, 2025, 4:32:18 AM
    Author     : GIGABYTE
--%>
<%@page import="dto.SkillDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="dao.SkillDAO"%>
<%@page import="dao.UserDAO"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserDTO s_user = (UserDTO) session.getAttribute("user");

    int userId = 0;
    if (request.getParameter("userId") != null) {
        userId = Integer.parseInt(request.getParameter("userId"));

    }
    SkillDAO sdao = new SkillDAO();
    List<SkillDTO> skills = sdao.getSkillsByUserId(userId);

    UserDAO udao = new UserDAO();
    UserDTO user = udao.getUserById(userId);

    // If the user does not exist, redirect to login or an error page
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    boolean isOwnProfile = (s_user != null && s_user.getUser_id() == userId);
%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- ✅ Mobile Responsive -->
        <title><%= user.getUsername()%>'s Profile</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/normal/userProfile.css">
    </head>
    <body> 
        <%@include file="includes/header.jsp" %> 
        <%
            UserDTO session_user = (UserDTO) request.getSession().getAttribute("user");
            if (session_user != null) {
        %>
        <div class="main-content">
            <div class="container">
                <div class="profile-header">
                    <img class="profile-pic" width="120px" height="120px" style="border-radius:50%" 
                         src="<%= (user.getProfilePictureUrl() != null) ? user.getProfilePictureUrl() : "assets/images/default-profile.png"%>" 
                         alt="Profile Picture">
                    <h1><%= (user.getFullName() != null) ? user.getFullName() : user.getUsername()%>'s Profile</h1>
                    <p class="bio"><%= (user.getBio() != null) ? user.getBio() : "No bio available."%></p>
                </div>

                <% if (isOwnProfile) { %>
                <form action="UpdateProfileController" method="post" enctype="multipart/form-data" class="upload-form">
                    <label for="profilePicture" class="custom-file-upload">Upload New Profile Picture</label>
                    <input type="file" id="profilePicture" name="profilePicture" accept="image/*" required>
                    <button type="submit" class="upload-btn">Update</button>
                </form>
                <% }%>

                <div class="profile-info">
                    <p><strong>Email:</strong> <%= user.getEmail()%></p>
                    <p><strong>Location:</strong> <%= (user.getLocation() != null) ? user.getLocation() : "Not specified"%></p>
                </div>

                <h2>Skills</h2>
                <% if (skills.isEmpty()) { %>
                <p>No skills listed.</p>
                <% } else { %>
                <ul class="skill-list">
                    <% for (SkillDTO skill : skills) {%>
                    <li>
                        <%= skill.getSkill_name()%> 
                        <% if (!isOwnProfile) {%> <!-- Hide swap button if it's their own profile -->
                        <a class="swap-btn" href="swapRequest.jsp?userId=<%= user.getUser_id()%>&skillId=<%= skill.getSkill_id()%>">
                            Swap
                        </a>
                        <% } %>
                    </li>
                    <% } %>
                </ul>
                <% }%>
            </div>
            <% } else {%>
            <a href="login.jsp" class="login-btn">Login</a>
            <% }%>
        </div>
        <%
            String mess = request.getAttribute("message") + "";
            mess = mess.equals("null") ? "" : mess;
        %>
        <%=mess%>
    </body>
    <%@include file="includes/footer.jsp" %> 
</html>
