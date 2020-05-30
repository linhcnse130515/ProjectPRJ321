/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_dto;

/**
 *
 * @author nguye
 */
public class AccountGmail {
    private String code;
    private String gmail;
    private String fullName;
    private String role;

    public AccountGmail(String code, String gmail, String fullName, String role) {
        this.code = code;
        this.gmail = gmail;
        this.fullName = fullName;
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
