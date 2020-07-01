/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_dto;

import java.io.Serializable;

/**
 *
 * @author duyan
 */
public class UserErr implements Serializable{
    private String userIDErr;
    private String userNameErr;
    private String passWordErr;
    private String roleIDErr;

    public UserErr() {
    }

    public UserErr(String userIDErr, String userNameErr, String passWordErr, String roleIDErr) {
        this.userIDErr = userIDErr;
        this.userNameErr = userNameErr;
        this.passWordErr = passWordErr;
        this.roleIDErr = roleIDErr;
    }

    public String getUserIDErr() {
        return userIDErr;
    }

    public String getUserNameErr() {
        return userNameErr;
    }

    public String getPassWordErr() {
        return passWordErr;
    }

    public String getRoleIDErr() {
        return roleIDErr;
    }

    public void setUserIDErr(String userIDErr) {
        this.userIDErr = userIDErr;
    }

    public void setUserNameErr(String userNameErr) {
        this.userNameErr = userNameErr;
    }

    public void setPassWordErr(String passWordErr) {
        this.passWordErr = passWordErr;
    }

    public void setRoleIDErr(String roleIDErr) {
        this.roleIDErr = roleIDErr;
    }
    
}
