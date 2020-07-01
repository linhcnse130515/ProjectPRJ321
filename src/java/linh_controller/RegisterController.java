/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import linh_dao.UserDAO;
import linh_dto.UserDTO;
import linh_dto.UserErr;

/**
 *
 * @author nguye
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private final String SUCCESS = "index.jsp";
    private final String ERR = "register.jsp";

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
        PrintWriter out = response.getWriter();
        String url = ERR;
        UserErr errors = new UserErr();
        try {
            String userID = request.getParameter("txtUserID");
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassWord");
            String rePassWord = request.getParameter("txtConfirm");
            boolean valid = true;
            if (userID.length() < 3 || userID.length() > 10) {
                errors.setUserIDErr("ID has to from 3 to 10 char!");
                valid = false;
            }
            if (userID.isEmpty()) {
                errors.setUserIDErr("ID can't be blank!");
                valid = false;
            }
            if (userName.isEmpty()) {
                errors.setUserNameErr("UserName can't be blank!");
                valid = false;
            }
            if (password.length() < 1 || password.length() > 15) {
                errors.setPassWordErr("Password has to from 1 to 15 char!");
                valid = false;
            }
            if (password.isEmpty()) {
                errors.setPassWordErr("Password can't be blank!");
                valid = false;
            }
            if (!rePassWord.equals(password)) {
                errors.setPassWordErr("Password is not match!");
                valid = false;
            }
            if (valid) {
                UserDAO dao = new UserDAO();
                UserDTO dto = new UserDTO(userID, password , "User",  userName);
                if (dao.insert(dto)) {
                    url = SUCCESS;
                    HttpSession session = request.getSession();
                    session.setAttribute("ERRORS", null);
                }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("ERRORS", errors);
            }

        } catch (Exception ex) {
            log("Exception at RegisterController  " + ex.getMessage());
            if (ex.getMessage().contains("duplicate")) {
                errors.setUserIDErr("UserID is existed!");
                HttpSession session = request.getSession();
                session.setAttribute("ERRORS", errors);
            }

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            //response.sendRedirect(url);
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
