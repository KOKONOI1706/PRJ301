<%-- 
    Document   : viewSwapRequests
    Created on : Mar 26, 2025, 5:46:55 AM
    Author     : GIGABYTE
--%>

<%@page import="dto.SkillDTO"%>
<%@page import="dao.SkillDAO"%>
<%@page import="dao.UserDAO"%>

<%@ page import="java.util.List, dto.SwapRequestDTO, dao.SwapRequestDAO, dto.UserDTO" %>

<%
    UserDTO s_user = (UserDTO) session.getAttribute("user");
    if (s_user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int receiverId = s_user.getUser_id();
    SwapRequestDAO swapRequestDAO = new SwapRequestDAO();
    List<SwapRequestDTO> swapRequests = swapRequestDAO.getSwapRequestsByUserId(receiverId);
    System.out.println(swapRequests);
%>

<!DOCTYPE html>
<html>
    <head>
        <title>View Swap Requests</title>
        <link rel="stylesheet" type="text/css" href="assets/css/normal/viewSwapRequests.css "> 
    </head>
    <body>
        <%@include file="includes/header.jsp" %> 
        <div class="container">
            <h2>Pending Swap Requests</h2>
            <% if (swapRequests.isEmpty()) { %>

            <p>No pending swap requests.</p>
            <% } else { %>
            <table>
                <tr>
                    <th>Sender</th>
                    <th>Skill Requested</th>
                    <th>Skill Offered</th>
                    <th>Status</th>
                    <th>Send At</th>
                    <th>Action</th>
                </tr>

                <% for (SwapRequestDTO Srequest : swapRequests) {
                        UserDAO udao = new UserDAO();
                        UserDTO sender = udao.getUserById(Srequest.getSender_id());
                        SkillDAO sdao = new SkillDAO();
                        SkillDTO skill_offer = sdao.getSkillById(Srequest.getSkill_offered_id());
                        SkillDTO skill_request = sdao.getSkillById(Srequest.getSkill_requested_id());
                        if ("Pending".equals(Srequest.getStatus()) && Srequest.getReceiver_id() == receiverId) {%>
                <tr>
                    <td><%= sender.getFullName()%></td>
                    <td><%= skill_request.getSkill_name()%></td>
                    <td><%= skill_offer.getSkill_name()%></td>  
                    <td><%= Srequest.getStatus()%></td> 
                    <td><%= Srequest.getRequestDate()%></td>
                    <td>
                        <form action="ManageSwapRequestController" method="post">
                            <input type="hidden" name="requestId" value="<%= Srequest.getRequest_id()%>">
                            <input type="hidden" name="senderId" value="<%= Srequest.getSender_id()%>">
                            <button type="submit" name="action" value="accept">Accept</button>
                            <button type="submit" name="action" value="reject">Reject</button>
                        </form>
                    </td>
                </tr>
                <% }
                    } %>
            </table>
            <% }%>
            <%
                String mess = request.getAttribute("message") + "";
                mess = mess.equals("null") ? "" : mess;
                if (mess.equals("Accept request successfully!")) {
            %>
            <span style="color:green"<%=mess%></span>
            <%} else if (mess.equals("Rejected successfully!")) {%>
            <span style="color:red"<%=mess%></span>
            <%}%>
        </div>
        <%@include file="includes/footer.jsp" %> 
    </body>
</html>
