<%-- 
    Document   : skillDetail
    Created on : Mar 24, 2025, 6:26:43 PM
    Author     : GIGABYTE
--%>

<%@page import="dao.SkillDAO"%>
<%@page import="java.util.List"%>
<%@page import="dto.SkillDTO"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserDTO u = (UserDTO) request.getSession().getAttribute("user");
    SkillDTO skill = (SkillDTO) request.getAttribute("skill");
    List<UserDTO> users = (List<UserDTO>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><%= (skill != null) ? "Users with Skill - " + skill.getSkill_name() : "Skill Not Found"%></title>
        <%@include file="includes/header.jsp" %> 
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/normal/skillDetail.css"/>

    </head>
    <body>
        <div class="main-content">
            <div class="container">
                <% if (skill != null) {%>
                <h1>Skill: <%= skill.getSkill_name()%> (Category: <%= skill.getCategory()%>)</h1>

                <form action="SkillDetailController" method="get" class="sort-form">
                    <input type="hidden" name="skillId" value="<%=skill.getSkill_id()%>"/>
                    <label for="sortBy">Sort by:</label>
                    <select name="sortBy" id="sortBy">
                        <option value="rating">Rating</option>
                        <option value="name">Name</option>
                    </select>
                    <button type="submit" class="sort-btn">Sort</button>
                </form>

                <div class="results-container">
                    <h2>Users with this Skill:</h2>
                    <%
                        if (users != null && !users.isEmpty()) {
                    %>
                    <table>
                        <thead>
                            <tr>
                                <th>Username</th>
                                
                                <th>View</th>
                                <th>Swap</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (UserDTO user : users) {
                                    if (u != null && user.getUser_id() == u.getUser_id()) {
                                        continue;
                                    }
                            %>
                            <tr>
                                <td><%= user.getUsername()%></td>
                                
                                <td><a href="userProfile.jsp?userId=<%=user.getUser_id()%>">View Profile</a></td>
                                <td> <a href="swapRequest.jsp?userId=<%=user.getUser_id()%>&skillId=<%=skill.getSkill_id()%>">Request Swap</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    <% } else { %>
                    <p class="no-result">No users found for this skill.</p>
                    <% } %>
                </div>

                <% } else { %>
                <h1>Skill Not Found</h1>
                <% }%>

                <a href="searchSkill.jsp" class="back-link">← Back to Skills</a>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %> 
    </body>
</html>
