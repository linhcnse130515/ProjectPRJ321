/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import linh_dto.AccountGmail;
import linh_dto.GooglePojo;
import linh_dto.UserDTO;
import linh_utils.DBUtils;

/**
 *
 * @author nguye
 */
public class UserDAO implements Serializable{
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO result = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleName FROM tblUsers U,tblRole R WHERE U.roleID = R.roleID AND userID = ? AND password = ? AND status = 'True'";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new UserDTO(rs.getString("roleName").trim(), rs.getString("fullName").trim());
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
    
    public AccountGmail checkMail(GooglePojo GP) throws SQLException{
        AccountGmail result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleName FROM tblUserMail U,tblRole R WHERE U.roleID = R.roleID AND code = ? AND status = 'True'";
                stm = conn.prepareStatement(sql);
                stm.setString(1, GP.getId());
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new AccountGmail(GP.getId(), GP.getEmail(), rs.getString("fullName"), rs.getString("roleName"));
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
    
    public void InsertAccMail(AccountGmail AG) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "Insert into tblUserMail(code, gmail, fullName, status, roleID) values(?,?,?,'True',?)";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, AG.getCode());
            stm.setString(2, AG.getGmail());
            stm.setString(3, AG.getFullName());
            stm.setString(4, "002");
            stm.executeUpdate();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
