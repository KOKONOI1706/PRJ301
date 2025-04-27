/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SkillDAO;
import dao.SwapRequestDAO;
import dao.UserDAO;

import dto.UserDTO;
import java.io.IOException;

import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "SwapRequestController", urlPatterns = {"/SwapRequestController"})
public class SwapRequestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String url = "userProfile.jsp";
    private static final Logger LOGGER = Logger.getLogger(SwapRequestDAO.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int sessionUserId = Integer.parseInt(request.getParameter("sessionUserId"));
            int targetUserId = Integer.parseInt(request.getParameter("targetUserId"));
            int targetSkillId = Integer.parseInt(request.getParameter("skillId"));
            int mySkillId = Integer.parseInt(request.getParameter("mySkillId"));
            System.out.println(sessionUserId);
            System.out.println(targetSkillId);
            System.out.println(targetSkillId);
            System.out.println(mySkillId);
            
            SwapRequestDAO srdao = new SwapRequestDAO();
            boolean result = srdao.createSwapRequest(sessionUserId, targetUserId, targetSkillId, mySkillId);

            if (result) {
                
                request.setAttribute("message", "Swap request sent successfully!");
                request.getRequestDispatcher("swapRequest.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Failed to send swap request.");
                request.getRequestDispatcher("swapRequest.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("message", "Something went wrong: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Error processing swap request", e);
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
