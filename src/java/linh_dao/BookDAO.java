/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import linh_dto.BookDTO;
import linh_utils.DBUtils;

/**
 *
 * @author nguye
 */
public class BookDAO {

    Connection conn;
    PreparedStatement pre;
    ResultSet rs;

    public List<BookDTO> list(String borDay, String payDay) throws SQLException {
        List<BookDTO> result = new ArrayList();
        Connection conn = null;
        PreparedStatement stm = null;
        PreparedStatement stm1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookCode, bookName, author, quantity, image, status FROM tblBooks";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String code = rs.getString("bookCode");
                    String bookName = rs.getString("bookName");
                    String author = rs.getString("author");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String sql1 = "SELECT SUM(quantity) AS sum \n"
                            + "FROM tblCartDetail \n"
                            + "WHERE bookCode = ? AND\n"
                            + "	cartID in (SELECT cartID \n"
                            + "FROM tblCart\n"
                            + "WHERE ((borrowDay < ?) and (payDay > ?))or\n" 
                            + "      ((borrowDay < ?) and (payDay > ?))\n" 
                            + ")";
                    stm1 = conn.prepareStatement(sql1);
                    stm1.setString(1, code);
                    stm1.setString(2, payDay);
                    stm1.setString(3, payDay);
                    stm1.setString(4, borDay);
                    stm1.setString(5, borDay);
                    rs1 = stm1.executeQuery();
                    if (rs1.next()){
                        quantity = quantity - rs1.getInt("sum");
                    }
                    result.add(new BookDTO(code, bookName, author, quantity, status, image));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs1 != null) {
                rs1.close();
            }
            if (stm1 != null) {
                stm1.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<BookDTO> list() throws SQLException {
        List<BookDTO> result = new ArrayList();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookCode, bookName, author, quantity, image, status FROM tblBooks";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String code = rs.getString("bookCode");
                    String bookName = rs.getString("bookName");
                    String author = rs.getString("author");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    result.add(new BookDTO(code, bookName, author, quantity, status, image));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void insert(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT tblBooks(bookCode, bookName, author, quantity, image, status) VALUES(?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, book.getCode());
                stm.setString(2, book.getName());
                stm.setString(3, book.getAuthor());
                stm.setInt(4, book.getQuantity());
                stm.setString(5, book.getImage());
                stm.setBoolean(6, book.isStatus());
                stm.executeUpdate();
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

    public void delete(String proID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblBooks SET status = 'false' WHERE bookCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, proID);
                int n = stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblBooks SET bookName =?, author =?, quantity = ?, image = ?, status = ? WHERE bookCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, book.getName());
                stm.setString(2, book.getAuthor());
                stm.setInt(3, book.getQuantity());
                stm.setString(4, book.getImage());
                stm.setBoolean(5, book.isStatus());
                stm.setString(6, book.getCode());
                stm.executeUpdate();
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
    
    public int getQuantity(String code, String borDay, String payDay) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT SUM(quantity) AS sum \n"
                            + "FROM tblCartDetail \n"
                            + "WHERE bookCode = ? AND\n"
                            + "	cartID in (SELECT cartID \n"
                            + "FROM tblCart\n"
                            + "WHERE ((borrowDay < ?) and (payDay > ?))or\n" 
                            + "      ((borrowDay < ?) and (payDay > ?))\n" 
                            + ")";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, code);
                    stm.setString(2, payDay);
                    stm.setString(3, payDay);
                    stm.setString(4, borDay);
                    stm.setString(5, borDay);
                    rs = stm.executeQuery();
                    if (rs.next()){
                        result = rs.getInt("sum");
                    }
                sql = "SELECT quantity FROM tblBooks WHERE bookCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, code);
                rs = stm.executeQuery();
                if(rs.next()){
                    result = rs.getInt("quantity") - result;
                }
            }
        } catch (Exception e) {
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
