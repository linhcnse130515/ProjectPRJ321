/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import linh_dto.CartDTO;
import linh_dto.BookDTO;
import linh_utils.DBUtils;

/**
 *
 * @author nguye
 */
public class OrderDAO implements Serializable {

    public void insert(CartDTO cart, String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        CartDTO list;
        String sql;
        try {
            conn = DBUtils.getConnection();
            Random rd = new Random();
            int cartID = 0;
            if (conn != null) {
                while (check == false) {
                    cartID = rd.nextInt(1000);
                    sql = "INSERT tblCart (cartID, borrowDay, payDay, userID, status) VALUES(?,?,?,?,'True')";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, cartID);
                    stm.setString(2, cart.getBorDay());
                    stm.setString(3, cart.getPayDay());
                    stm.setString(4, userID);
                    check = stm.executeUpdate() > 0;;
                }
                for (Map.Entry<String, BookDTO> entrySet : cart.getCart().entrySet()) {
                    String key = entrySet.getKey();
                    int quantity = entrySet.getValue().getQuantity();
                    sql = "INSERT tblCartDetail(cartID, bookCode, quantity) VALUES(?,?,?)";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, cartID);
                    stm.setString(2, key);
                    stm.setInt(3, quantity);
                    stm.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

//    public List<OrderDTO> showAll(String userID) throws SQLException {
//        List<OrderDTO> result = new ArrayList();
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "SELECT orderID, arrivalDate, departureDate, total FROM tblOrder where userID = ?";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, userID);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String orderID = rs.getString("orderID");
//                    Date arrivalDate = Date.valueOf(rs.getString("arrivalDate"));
//                    Date departureDate = Date.valueOf(rs.getString("departureDate"));
//                    float total = rs.getFloat("total");
//                    result.add(new OrderDTO(orderID, arrivalDate, departureDate, total));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return result;
//    }
//
//    public List<ProductDTO> search(String orderID) throws SQLException {
//        List<ProductDTO> result = new ArrayList();
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "Select OD.proID,P.proName,P.price,OD.quantity from tblOrderDetail OD, tblProducts P where OD.proID = P.proID AND orderID = ?";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, orderID);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String proName = rs.getString("proName");
//                    float price = rs.getFloat("price");
//                    int quantity = rs.getInt("quantity");
//                    result.add(new ProductDTO(proName, price, quantity));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return result;
//    }
}
