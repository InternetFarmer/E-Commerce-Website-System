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
public class RecordDBModel implements Serializable {

    private int transaction_id;
    private int product_id;
    private int amount;
    private int price;
    private ProductDBModel product;

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductDBModel getProduct() {
        return product;
    }

    public void setProduct(ProductDBModel product) {
        this.product = product;
    }
    
    
}
