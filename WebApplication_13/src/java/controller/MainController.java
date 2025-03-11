    package controller;

import dao.ProjectDAO;
import dao.UserDAO;
import dto.ProjectDTO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";
    private static final String DASHBOARD_PAGE = "dashboard.jsp";
    private final ProjectDAO projectDAO = new ProjectDAO();
    private final UserDAO userDAO = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        
        try {
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("user");

            if (action == null) {
                url = LOGIN_PAGE;
            } else if (action.equals("login")) {
                url = handleLogin(request, session);
            } else if (action.equals("logout")) {
                url = handleLogout(session);
            } else if (user != null) {
                if (action.equals("viewProjects")) {
                    url = handleViewProjects(request);
                } else if (user.getRoleId().equals("Founder")) { 
                    if (action.equals("create")) {
                        url = handleCreateProject(request);
                    } else if (action.equals("update")) {
                        url = handleUpdateProject(request);
                    } else if (action.equals("delete")) {
                        url = handleDeleteProject(request);
                    }
                } else {
                    request.setAttribute("message", "You do not have permission for this action.");
                    url = DASHBOARD_PAGE;
                }
            } else {
                request.setAttribute("message", "Please login first.");
                url = LOGIN_PAGE;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    
    private String handleLogin(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDTO user = userDAO.readbyID(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            request.setAttribute("projects", projectDAO.getAllProjects());
            return DASHBOARD_PAGE;
        } else {
            request.setAttribute("message", "Incorrect Username or Password.");
            return LOGIN_PAGE;
        }
    }

    
    private String handleLogout(HttpSession session) {
        session.invalidate();
        return LOGIN_PAGE;
    }

    
    private String handleViewProjects(HttpServletRequest request) {
        List<ProjectDTO> projects = projectDAO.getAllProjects();
        request.setAttribute("projects", projects);
        return DASHBOARD_PAGE;
    }

  
    private String handleCreateProject(HttpServletRequest request) {
        try {
            int projectId = Integer.parseInt(request.getParameter("project_id"));
            String projectName = request.getParameter("project_name");
            String projectDescription = request.getParameter("project_description");
            String projectStatus = request.getParameter("project_status");
            Date estimatedLaunch = Date.valueOf(request.getParameter("project_estimatedLaunch"));

            ProjectDTO project = new ProjectDTO(projectId, projectName, projectDescription, projectStatus, estimatedLaunch);
            boolean success = projectDAO.create(project);

            if (success) {
                request.setAttribute("message", "Project created successfully!");
            } else {
                request.setAttribute("message", "Failed to create project.");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Invalid project data.");
        }
        request.setAttribute("projects", projectDAO.getAllProjects());
        return DASHBOARD_PAGE;
    }

    
    private String handleUpdateProject(HttpServletRequest request) {
        try {
            int projectId = Integer.parseInt(request.getParameter("project_id"));
            String newStatus = request.getParameter("project_status");

            boolean success = projectDAO.updateStatus(projectId, newStatus);

            if (success) {
                request.setAttribute("message", "Project updated successfully!");
            } else {
                request.setAttribute("message", "Failed to update project.");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Invalid project data.");
        }
        request.setAttribute("projects", projectDAO.getAllProjects());
        return DASHBOARD_PAGE;
    }

    // ✅ Delete Project (Founder Only)
    private String handleDeleteProject(HttpServletRequest request) {
        try {
            int projectId = Integer.parseInt(request.getParameter("project_id"));

            boolean success = projectDAO.delete(projectId);

            if (success) {
                request.setAttribute("message", "Project deleted successfully!");
            } else {
                request.setAttribute("message", "Failed to delete project.");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Invalid project data.");
        }
        request.setAttribute("projects", projectDAO.getAllProjects());
        return DASHBOARD_PAGE;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Startup Project Management Controller";
    }
}
