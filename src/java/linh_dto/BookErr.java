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
public class BookErr implements Serializable{
    private String bookIDErr;
    private String bookNameErr;
    private String bookQuanErr;
    private String statusErr;

    public BookErr() {
    }
    
    public String getBookIDErr() {
        return bookIDErr;
    }

    public void setBookIDErr(String bookIDErr) {
        this.bookIDErr = bookIDErr;
    }

    public String getBookNameErr() {
        return bookNameErr;
    }

    public void setBookNameErr(String bookNameErr) {
        this.bookNameErr = bookNameErr;
    }

    public String getBookQuanErr() {
        return bookQuanErr;
    }

    public void setBookQuanErr(String bookQuanErr) {
        this.bookQuanErr = bookQuanErr;
    }

    

    public String getStatusErr() {
        return statusErr;
    }

    public void setStatusErr(String statusErr) {
        this.statusErr = statusErr;
    }

    
    
}
