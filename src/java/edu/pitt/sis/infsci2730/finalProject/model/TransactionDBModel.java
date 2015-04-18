/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 *
 * @author Wu
 */
public class TransactionDBModel implements Serializable {
    
    private int transaction_id;
    private Timestamp transaction_date;
    private int customer_id;
//    private int salesperson_id;
    private int totoalAmount;

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Timestamp getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Timestamp transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

//    public int getSalesperson_id() {
//        return salesperson_id;
//    }
//
//    public void setSalesperson_id(int salesperson_id) {
//        this.salesperson_id = salesperson_id;
//    }

    public int getTotoalAmount() {
        return totoalAmount;
    }

    public void setTotoalAmount(int totoalAmount) {
        this.totoalAmount = totoalAmount;
    }
}
