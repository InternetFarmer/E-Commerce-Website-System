/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.model;

import java.io.Serializable;

/**
 *
 * @author Wu
 */

public class ProductDBModel implements Serializable {
    
    private int product_id;
    private String product_name;
    private int inventory_amount;
    private int price;
    private int category_id;
    private int buying_price;
    private ProductCategoryDBModel category;
    
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getInventory_amount() {
        return inventory_amount;
    }

    public void setInventory_amount(int inventory_amount) {
        this.inventory_amount = inventory_amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(int buying_price) {
        this.buying_price = buying_price;
    }

    public ProductCategoryDBModel getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryDBModel category) {
        this.category = category;
    }
    
    
}
