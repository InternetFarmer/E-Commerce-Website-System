/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.model;

public class CustomerDBModel {

    private int customer_id;
    private int address_id;
    private String customer_name;
//    private String type;
//    private String business_category;
//    private String company_gross_income;
//    private String marriage_status;
    private String gender;
    private String age;
    private String income;
    private AddressDBModel address;

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

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getBusiness_category() {
//        return business_category;
//    }
//
//    public void setBusiness_category(String business_category) {
//        this.business_category = business_category;
//    }
//
//    public String getCompany_gross_income() {
//        return company_gross_income;
//    }
//
//    public void setCompany_gross_income(String company_gross_income) {
//        this.company_gross_income = company_gross_income;
//    }
//
//    public String getMarriage_status() {
//        return marriage_status;
//    }
//
//    public void setMarriage_status(String marriage_status) {
//        this.marriage_status = marriage_status;
//    }

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

    public AddressDBModel getAddress() {
        return address;
    }

    public void setAddress(AddressDBModel address) {
        this.address = address;
    }
}
