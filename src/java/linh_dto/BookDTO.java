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
public class BookDTO {
    private String code,name,author;
    private int quantity;
    private boolean status;
    private String image;

    public BookDTO(String code, String name, String author, int quantity, boolean status, String image) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.status = status;
        this.image = image;
    }

    public BookDTO(String code, String name, String author, int quantity) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
}
