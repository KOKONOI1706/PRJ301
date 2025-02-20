/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})

public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public UserDTO getUser(String strUserID){
        UserDAO udao = new UserDAO();
        UserDTO user = udao.readById(strUserID);
        return user;
    }
    public boolean isValidLogin(String strUserID, String strPassword) {
        UserDTO user = getUser(strUserID);
        if (user == null) {
            return false;
        } else {
            return user.getPassword().equals(strPassword);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = LOGIN_PAGE;
            try {
                String action = request.getParameter("action");
                if (action == null) {
                    url = LOGIN_PAGE;
                }
                if (action != null && action.equals("login")) {
                    String txt_user = request.getParameter("user");
                    String txt_password = request.getParameter("pass");
                    if (isValidLogin(txt_user, txt_password)) {
                        url = "user.jsp";
                        UserDTO user = getUser(txt_user);
                        request.setAttribute("user", user);
                    } else {
                        request.setAttribute("message", "Incorrect user id or password");
                        url = "login.jsp";
                    }
                }else if(action != null && action.equals("login")){
                    url = "Logout";
                   request.setAttribute("user", null);
                   out.print("<b> You are logged out!</b> </br>");
                   out.print("<a href='MainController'> Back to login page</a>");
                }
            } catch (Exception e) {
                log("Error at Maincontroller: " + e.toString());
            }finally{
                RequestDispatcher rd = request.getRequestDispatcher(url);
                if(!url.equals("Logout")){
                    rd.forward(request, response);
                }
                
            }
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
