/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.dao.CustomerDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wu
 */
public class CustomerService {

    public CustomerDBModel login(final String[] para) throws SQLException {
        return CustomerDao.login(para);
    }

    public CustomerDBModel getCustomerById(final String id) throws SQLException {
        return CustomerDao.getCustomerById(id);
    }

    public CustomerDBModel getCustomerByCustomerName(final String name) throws SQLException {
        return CustomerDao.getCustomerByCustomerName(name);
    }

    public List<CustomerDBModel> getAllCustomers() throws SQLException {
        return CustomerDao.getAllCustomers();
    }

    public int updateCustomerNameById(final String[] para) throws SQLException {
        return CustomerDao.updateCustomerById(para);
    }

    //bug
    public int addCustomer(final String[] para) throws SQLException {
        return CustomerDao.addCustomer(para);
    }

    public List<CustomerDBModel> SearchCustomer(final String name) throws SQLException {
        return CustomerDao.SearchCustomer(name);

    }

    public int deleteCustomerById(final String id) throws SQLException {
        return CustomerDao.deleteCustomerById(id);
    }

}
