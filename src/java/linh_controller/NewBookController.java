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
import linh_dao.BookDAO;
import linh_dto.BookDTO;
import linh_dto.BookErr;

/**
 *
 * @author nguye
 */
@WebServlet(name = "NewBookController", urlPatterns = {"/NewBookController"})
public class NewBookController extends HttpServlet {
    private static String SUCCESS = "AdminController";
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
        response.setContentType("text/html;charset=UTF-8");request.setCharacterEncoding("utf-8");
        String url = SUCCESS;
        BookErr errors = new BookErr();
        String code = request.getParameter("txtCode");
        String name = request.getParameter("txtName");
        String author = request.getParameter("txtAuthor");
        int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        String image = request.getParameter("txtImage");
        try {
            boolean valid = true;
            if (code.length() < 3){
                errors.setBookIDErr("ID has to from 3 char!");
                valid = false;
            }
            if (code.isEmpty()) {
                errors.setBookIDErr("ID can't be blank!");
                valid = false;
            }           
            if (name.isEmpty()) {
                errors.setBookNameErr("Name can't be blank!");
                valid = false;
            }
            
            if (author.isEmpty()) {
                errors.setStatusErr("Status can't be blank!");
                valid = false;
            }
            if (quantity < 0){
                errors.setBookQuanErr("Quantity must be greater than 0!");
                valid = false;
            }
            if (valid) {
                BookDAO dao = new BookDAO();
                BookDTO dto = new BookDTO(code, name, author, quantity, true, image);               
                dao.insert(dto);
            } else {
                request.setAttribute("ERRORSBOOK", errors);
            }

        } catch (Exception ex) {
            log("Exception at AddProController  " + ex.getMessage());
            if (ex.getMessage().contains("duplicate")) {
                errors.setBookIDErr("Book ID is existed!");
                request.setAttribute("ERRORSBOOK", errors);
            }

        } finally {
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
