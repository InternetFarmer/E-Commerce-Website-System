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

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static Customer login(final String[] para) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_id = ? and password = ?",
                para,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR},
                new CustomerRowMapper());
    }

    public static Customer getCustomerById(final String id) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new CustomerRowMapper());
    }

    public static Customer getCustomerByCustomerName(final String name) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_name = ?",
                new Object[]{name},
                new int[]{java.sql.Types.VARCHAR},
                new CustomerRowMapper());
    }

    public static List<Customer> getAllCustomers() {
        return jdbcTemplate.query("select * from Customer",
                new CustomerRowMapper());
    }

    public static int updateCustomerNameById(final String[] para) {
        int ret = jdbcTemplate.update("update Customer set customer_name = ? where customer_id = ?",
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
        return ret;
    }

    //bug
    public static int addCustomer(final String[] para) {
        return jdbcTemplate.update("insert into Customer (address_id, customer_name,password, gender,age,income) values (?,?,'12345',?,?,?)",
                para,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.CHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR});
    }

    public static List<Customer> SearchCustomer(final String name) {
        return jdbcTemplate.query("select * from Customer where customer_name like '%" + name + "%'",
                new CustomerRowMapper());

    }

    public static int deleteCustomerById(final String id) {
        int ret = jdbcTemplate.update("delete from Customer where customer_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
        return ret;
    }
}
