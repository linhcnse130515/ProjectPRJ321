/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import linh_dto.BookDTO;
import linh_dto.CartDTO;

/**
 *
 * @author nguye
 */
@WebServlet(name = "AddCartController", urlPatterns = {"/AddCartController"})
public class AddCartController extends HttpServlet {

    private final String SUCCESS = "GetAllBooksController";

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
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession();
            String borDay = request.getParameter("BORDAY");
            String payDay = request.getParameter("PAYDAY");
            String bookString = request.getParameter("BookString");
            int amount = Integer.parseInt(request.getParameter("txtAmount"));
            String tmp[] = bookString.split("-");
            BookDTO dto = new BookDTO(tmp[0], tmp[1], tmp[2], 0);
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDTO(borDay, payDay);
            }
            cart.add(dto, 0);
            if(amount < 1){
                request.setAttribute("MESSAGEBOOK", "You have selected the number of book greater than 0");
            }else
            if (cart.getQuantity(dto) + amount > Integer.parseInt(tmp[3])) {
                request.setAttribute("MESSAGEBOOK", "You have selected the number of book that exceeds the remaining quantity");
            } else {
                cart.add(dto, amount);
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGEBOOK", "You add " + tmp[1] + " to card successful!");
            }
            request.setAttribute("BORDAY", borDay);
            request.setAttribute("PAYDAY", payDay);
        } catch (Exception e) {
            log("Exception at BookController: " + e.toString());
        } finally {
            request.getRequestDispatcher(SUCCESS).forward(request, response);
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
