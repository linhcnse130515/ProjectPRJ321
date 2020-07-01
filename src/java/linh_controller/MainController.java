/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class MainController extends HttpServlet {
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String REGISNA = "RegisNameController";
    private static final String ADMIN = "AdminController";
    private static final String DELBOOK = "DeleteBookController";
    private static final String UPDBOOK = "UpdateBookController";
    private static final String NEWBOOK = "NewBookController";
    private static final String GETALL = "GetAllBooksController";
    private static final String ADDCART = "AddCartController";
    private static final String REMOVE = "RemoveCartController";
    private static final String SAVE = "SaveCartController";
    private static final String ORDER = "OrderController";
    private static final String DELCART = "DeleteCartController";
    private static final String REGISTER = "RegisterController";
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
        String success = "";
        try {
            String btn = request.getParameter("btnAction");
            if (btn.equals("Login")){
                success = LOGIN;
            }else if (btn.equals("Logout")){
                success = LOGOUT;
            }else if (btn.equals("RegisName")){
                success = REGISNA;
            }else if (btn.equals("Admin")){
                success = ADMIN;
            }else if (btn.equals("Delete Book")){
                success = DELBOOK;
            }else if (btn.equals("Update Book")){
                success = UPDBOOK;
            }else if (btn.equals("New Book")){
                success = NEWBOOK;
            }else if (btn.equals("GetAll")){
                success = GETALL;
            }else if (btn.equals("AddCart")){
                success = ADDCART;
            }else if (btn.equals("Remove Book")){
                success = REMOVE;
            }else if (btn.equals("Save")){
                success = SAVE;
            }else if (btn.equals("Order")){
                success = ORDER;
            }else if (btn.equals("DeleteCart")){
                success = DELCART;
            }else if (btn.equals("Register")){
                success = REGISTER;
            }
        } catch (Exception e) {
        }finally{
            request.getRequestDispatcher(success).forward(request, response);
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
