/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.utils;


import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class CustomerRowMapper implements RowMapper<CustomerDBModel> {
        public CustomerDBModel mapRow(ResultSet rs, int index) throws SQLException {
        CustomerDBModel customer = new CustomerDBModel();
        
        customer.setCustomer_id(rs.getInt("CUSTOMER_ID"));
        customer.setAddress_id(rs.getInt("ADDRESS_ID"));
        customer.setCustomer_name(rs.getString("CUSTOMER_NAME"));
        customer.setGender(rs.getString("gender"));
        customer.setIncome(rs.getString("income"));
        customer.setAge(rs.getString("age"));
        
        return customer;
    }
}
