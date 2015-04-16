/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.bean.Customer;
import edu.pitt.sis.infsci2730.finalProject.rowMapper.CustomerRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class CustomerDao {

    private JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer login(String[] para) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_id = ? and password = ?",
                para,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR},
                new CustomerRowMapper());
    }

    public Customer getCustomerById(String id) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new CustomerRowMapper());
    }

    public Customer getCustomerByCustomerName(String name) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_name = ?",
                new Object[]{name},
                new int[]{java.sql.Types.VARCHAR},
                new CustomerRowMapper());
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("select * from Customer",
                new CustomerRowMapper());
    }

    public int updateCustomerNameById(String[] para) {
        int ret = jdbcTemplate.update("update Customer set customer_name = ? where customer_id = ?",
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
        return ret;
    }

    //bug
    public int addCustomer(String[] para) {
        return jdbcTemplate.update("insert into Customer (address_id, customer_name,password, gender,age,income) values (?,?,'12345',?,?,?)",
                para,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.CHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR});
    }

    public List<Customer> SearchCustomer(String name) {
        return jdbcTemplate.query("select * from Customer where customer_name like '%" + name + "%'",
                new CustomerRowMapper());

    }

    public int deleteCustomerById(String id) {
        int ret = jdbcTemplate.update("delete from Customer where customer_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
        return ret;
    }
}
