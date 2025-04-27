/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SwapRequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "ManageSwapRequestController", urlPatterns = {"/ManageSwapRequestController"})
public class ManageSwapRequestController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ManageSwapRequestController.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "viewSwapRequests.jsp";
  String requestIdStr = request.getParameter("requestId");
        String senderIdStr = request.getParameter("senderId");
        String action = request.getParameter("action");
        
        // ✅ Validate input before parsing integers
        if (requestIdStr == null || senderIdStr == null || action == null) {
            response.sendRedirect("viewSwapRequests.jsp?error=Invalid request parameters.");
            return;
        }

        try {
            int requestId = Integer.parseInt(requestIdStr);
            int senderId = Integer.parseInt(senderIdStr);

            SwapRequestDAO swapRequestDAO = new SwapRequestDAO();

            if ("accept".equals(action)) {
                boolean success = swapRequestDAO.acceptSwapRequest(requestId, senderId);
                if (success) {
                    request.setAttribute("message", "Accept request successfully!");
                } else {
                    request.setAttribute("message", "Failed to accept request");
                }
            } else if ("reject".equals(action)) {
                boolean success = swapRequestDAO.deleteSwapRequest(requestId);
                if (success) {
                     request.setAttribute("message", "Rejected successfully!");
                } else {
                     request.setAttribute("message", "Failed to accept request");
                }
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("viewSwapRequests.jsp?error=Invalid request ID or sender ID.");
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
