/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.Customer;
import edu.pitt.sis.infsci2730.finalProject.dao.CustomerDao;
import java.util.List;

/**
 *
 * @author Wu
 */
public class CustomerService {

    public Customer login(final String[] para) {
        return CustomerDao.login(para);
    }

    public Customer getCustomerById(final String id) {
        return CustomerDao.getCustomerById(id);
    }

    public Customer getCustomerByCustomerName(final String name) {
        return CustomerDao.getCustomerByCustomerName(name);
    }

    public List<Customer> getAllCustomers() {
        return CustomerDao.getAllCustomers();
    }

    public int updateCustomerNameById(final String[] para) {
        return CustomerDao.updateCustomerNameById(para);
    }

    //bug
    public int addCustomer(final String[] para) {
        return CustomerDao.addCustomer(para);
    }

    public List<Customer> SearchCustomer(final String name) {
        return CustomerDao.SearchCustomer(name);

    }

    public int deleteCustomerById(final String id) {
        return CustomerDao.deleteCustomerById(id);
    }

}
