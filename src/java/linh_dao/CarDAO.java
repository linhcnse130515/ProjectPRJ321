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
import linh_dto.CarDTO;

/**
 *
 * @author nguye
 */
public class CarDAO {
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;
    
    public CarDTO searchCar() throws SQLException{
        CarDTO result = null;
        try {
            
        } catch (Exception e) {
        }finally{
            if (rs != null){
                rs.close();
            }
            if (pre != null){
                pre.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return result;
    }
}
