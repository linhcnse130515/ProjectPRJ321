/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linh_dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class CartDTO {
    private Map<String, BookDTO> cart;
    private String borDay;
    private String payDay;

    public CartDTO(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public CartDTO() {
    }

    public CartDTO(String borDay, String payDay) {
        this.borDay = borDay;
        this.payDay = payDay;
    }
    
    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }
    
    public void add(BookDTO dto , int amount){
        if(this.cart == null){
            this.cart = new HashMap();
        }
        if(this.cart.containsKey(dto.getCode())){
            int quantity = this.cart.get(dto.getCode()).getQuantity();
            dto.setQuantity(quantity+amount);
        }
        cart.put(dto.getCode(), dto);
    }
    
    public int getQuantity(BookDTO dto){
        String a = dto.getCode();
        int quantity = 0;
        if(this.cart.containsKey(dto.getCode())){
            quantity = this.cart.get(dto.getCode()).getQuantity();
        }
        return quantity;
    }
    
    public void delete(String id){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    
    public void update(BookDTO dto){
        if(this.cart ==null){
            return;
        }
        if(this.cart.containsKey(dto.getCode())){
            this.cart.replace(dto.getCode(), dto);
        }
    }

    public String getBorDay() {
        return borDay;
    }

    public void setBorDay(String borDay) {
        this.borDay = borDay;
    }

    public String getPayDay() {
        return payDay;
    }

    public void setPayDay(String payDay) {
        this.payDay = payDay;
    }

    
    
}
