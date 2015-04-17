/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.model;


/**
 *
 * @author Wu
 */
public class StoreDBModel {
    
    private int store_id;
    private int address_id;
    private int store_manager;
    private int salesperson_number;
    private int region_id;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(int store_manager) {
        this.store_manager = store_manager;
    }

    public int getSalesperson_number() {
        return salesperson_number;
    }

    public void setSalesperson_number(int salesperson_number) {
        this.salesperson_number = salesperson_number;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
    
    
}
