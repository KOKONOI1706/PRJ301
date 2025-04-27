<%-- 
    Document   : searchSkill
    Created on : Mar 24, 2025, 4:58:56 PM
    Author     : GIGABYTE
--%>

<%@page import="java.util.List"%>
<%@page import="dto.SkillDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Search Skills - SwapSkill Hub</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/normal/searchSkill.css"/>
        <%@include file="includes/header.jsp" %> 
    </head>
    <body>
        <div class="main-content">
            <div class="container">
                <h1>Search Skills</h1>  

                <%
                    String mess = request.getAttribute("searchTerm") + "";
                    mess = mess.equals("null") ? "" : mess;
                %>

                <form action="SearchSkillController" method="get" class="search-form">
                    <label for="keyword">Skill Keyword:</label>
                    <input type="text" id="keyword" name="keyword" value="<%=mess%>"/>

                    <label for="category">Category:</label>
                    <select id="category" name="category">
                        <option value="" selected="">All</option>
                        <option value="language">Language</option>
                        <option value="coding">Coding</option>
                        <option value="art">Art</option>
                        <option value="IT">IT</option>
                    </select>

                    <button type="submit" class="search-btn">Search</button>
                </form>

                <div class="results-container">
                    <h2>Search Results:</h2>
                    <%
                        List<SkillDTO> list = (List<SkillDTO>) request.getAttribute("list");
                        if (list != null && !list.isEmpty()) {
                    %>

                    <table>
                        <thead>
                            <tr>
                                <th>Skill ID</th>
                                <th>Skill Name</th>
                                <th>Users Have It</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (SkillDTO sdto : list) {
                            %>
                            <tr>
                                <td><%=sdto.getSkill_id()%></td>
                                <td><%=sdto.getSkill_name()%></td>
                                <td><%=sdto.getUserCount()%></td>
                                <td>
                                    <a href="SkillDetailController?skillId=<%=sdto.getSkill_id()%>">View Users</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>

                    <% } else { %>
                    <p class="no-result">No skills found.</p>  
                    <% }%>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %> 
    </body>

</html>
