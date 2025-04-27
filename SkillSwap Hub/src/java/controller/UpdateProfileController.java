/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dto.UserDTO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "UpdateProfileController", urlPatterns = {"/UpdateProfileController"})
@MultipartConfig( 
    fileSizeThreshold = 1024 * 1024 * 2, 
    maxFileSize = 1024 * 1024 * 5, 
    maxRequestSize = 1024 * 1024 * 10 
)
public class UpdateProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int bytesRead;
        byte[] data = new byte[1024]; // Read in 1KB chunks
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Part filePart = request.getPart("profilePicture");

        if (filePart != null && filePart.getSize() > 0) {
            InputStream fileContent = null;
            try {
                fileContent = filePart.getInputStream();
                byte[] imageBytes = convertInputStreamToByteArray(fileContent);
                String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);

                UserDAO userDAO = new UserDAO();
                boolean success = userDAO.updateProfilePicture(user.getUser_id(), base64Image);

                if (success) {
                    response.sendRedirect("userProfile.jsp?userId=" + user.getUser_id() + "&message=Profile picture updated!");
                } else {
                    response.sendRedirect("userProfile.jsp?userId=" + user.getUser_id() + "&error=Failed to update profile picture.");
                }
            } finally {
                if (fileContent != null) {
                    fileContent.close();
                }
                try {
                    filePart.delete(); // Ensure file is deleted
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            response.sendRedirect("userProfile.jsp?userId=" + user.getUser_id() + "&error=No file uploaded.");
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
