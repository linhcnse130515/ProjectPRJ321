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
import linh_dto.CartDTO;

/**
 *
 * @author nguye
 */
@WebServlet(name = "SaveCartController", urlPatterns = {"/SaveCartController"})
public class SaveCartController extends HttpServlet {

    private final String SUCCESS = "cart.jsp";

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
        try {
            String code = request.getParameter("id");
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity > 0) {
                BookDTO dto = new BookDTO(code, name, author, quantity);
                HttpSession session = request.getSession();
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                BookDAO dao = new BookDAO();
                if(dao.getQuantity(code, cart.getBorDay(), cart.getPayDay()) >= quantity){
                    cart.update(dto);
                }else{
                    request.setAttribute("MESSAGEORDER", "You have selected the number of book that exceeds the remaining quantity");
                }
            } else {
                request.setAttribute("MESSAGEORDER", "Quantity must be greater than 0!");
            }
        } catch (Exception e) {
            log("Exception at BookController: " + e.toString());
        } finally {
            request.getRequestDispatcher(SUCCESS).forward(request, response);
            //response.sendRedirect(SUCCESS);
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
