/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.viewModel;

import edu.pitt.sis.infsci2730.finalProject.model.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer implements Serializable{

    private int customer_id;
    private int address_id;
    private String customer_name;
    private String password;
    private String gender;
    private String age;
    private String income;
    private Address address;

    public Customer(CustomerDBModel cm) {
        this.customer_id = cm.getCustomer_id();
        this.address_id = cm.getAddress_id();
        this.customer_name = cm.getCustomer_name();
        this.gender = cm.getGender();
        this.age = cm.getAge();
        this.income = cm.getIncome();
        //this.address = new Address(cm.getAddress());
    }
    
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}