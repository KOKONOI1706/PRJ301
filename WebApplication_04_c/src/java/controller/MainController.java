/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    public boolean isValidLogin(String username, String password) {
        return (username.equals("admin") && password.equals("12345678"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            if (name.isEmpty() || password.isEmpty()) {
                out.println("Please input username and password");
                return;
            }
            //check length
            if (password.trim().length() < 8) {
                out.println("Password must be at least 8 characters");
                return;
            }
            //login process
            if (isValidLogin(name, password)) {
                //Chuyen trang
                RequestDispatcher rd = request.getRequestDispatcher("search.html");
                rd.forward(request, response);
            } else {
//                RequestDispatcher rd = request.getRequestDispatcher("invalid.html");
//                rd.forward(request, response);
                response.sendRedirect("invalid.html");
                // rd.forward(request, response) va response.sendRedirect("invalid.html");
                // Using RequestDispatcher would forward response and request to "invalid.html"
                // The URL in the browser would remain the same as the origin login page
                // RequestDispatcher rd = request.getRequestDispatcher("invalid.html")
                // rd.forward(request, response);
                // Comment: The difference between rd.forward and response.sendRedirect:
                // - rd.forward: Server-side forwarding, URL does not change
                // - response.sendRedirect: Client-side redirection, URL changes 
            }

        }
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
