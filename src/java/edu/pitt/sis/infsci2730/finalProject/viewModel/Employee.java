/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.viewModel;

import edu.pitt.sis.infsci2730.finalProject.model.*;


public class Employee {
    
    private int employee_id;
    private String employee_name;
    private int address_id;
    private String jobtitle;
    private int priviledge;
    private int store_id;
    private String salary;
    private AddressDBModel address;
    
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public int getPriviledge() {
        return priviledge;
    }

    public void setPriviledge(int priviledge) {
        this.priviledge = priviledge;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public AddressDBModel getAddress() {
        return address;
    }

    public void setAddress(AddressDBModel address) {
        this.address = address;
    }
}
