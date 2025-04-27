<%-- 
    Document   : swapRequest.jsp
    Created on : Mar 26, 2025, 4:32:04 AM
    Author     : GIGABYTE
--%>

<%@page import="dao.SkillDAO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dto.SkillDTO"%>
<%@page import="dto.UserDTO"%>  

<%
    UserDTO s_User = (UserDTO) request.getSession().getAttribute("user");

    if (s_User == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String userIdStr = request.getParameter("userId");  
    String skillIdStr = request.getParameter("skillId");

    int userId = Integer.parseInt(userIdStr);
    int skillId = Integer.parseInt(skillIdStr);
    UserDAO udao = new UserDAO();
    UserDTO targetUser = udao.getUserById(userId);
    SkillDAO sdao = new SkillDAO();

    List<SkillDTO> sessionUserSkills = sdao.getSkillsByUserId(s_User.getUser_id());

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Swap Skill</title>
        <link rel="stylesheet" type="text/css" href="assets/css/normal/swapRequest.css"> <!-- Link CSS File -->
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div class="main-content">
            <h2>Request to Swap Skill with <%= targetUser.getUsername()%></h2>


            <form action="SwapRequestController" method="post" >
                <input type="hidden" name="sessionUserId" value="<%=s_User.getUser_id()%>">
                <input type="hidden" name="targetUserId" value="<%=targetUser.getUser_id()%>">
                <input type="hidden" name="skillId" value="<%=skillId%>">

                <label for="mySkill">Select your skill to exchange:</label>
                <select name="mySkillId" id="mySkill" required>
                    <% for (SkillDTO skill : sessionUserSkills) {
                            if (skill.getSkill_id() != skillId) {
                    %>
                    <option value="<%= skill.getSkill_id()%>"><%= skill.getSkill_name()%></option>
                    <% } else {%>
                    No different skill.
                    <% }%>
                    <% }%>
                </select>

                <button type="submit">Send Swap Request</button>
            </form>

            <%
                String mess = request.getAttribute("message") + "";
                mess = mess.equals("null") ? "" : mess;
            %>
            <%=mess%>
        </div>
        <%@include file="includes/footer.jsp" %> 
    </body>
</html>
