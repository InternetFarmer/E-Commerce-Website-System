/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.utils.CustomerRowMapper;
import java.sql.SQLException;
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

    public static CustomerDBModel login(final String[] para) throws SQLException {
        return jdbcTemplate.queryForObject("select * from Customer where customer_name = ? and password = ?",
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR},
                new CustomerRowMapper());
    }

    public static CustomerDBModel getCustomerById(final String id) throws SQLException {
        return jdbcTemplate.queryForObject("select * from Customer where customer_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new CustomerRowMapper());
    }

    public static CustomerDBModel getCustomerByCustomerName(final String name) throws SQLException {
        return jdbcTemplate.queryForObject("select * from Customer where customer_name = ?",
                new Object[]{name},
                new int[]{java.sql.Types.VARCHAR},
                new CustomerRowMapper());
    }

    public static List<CustomerDBModel> getAllCustomers() throws SQLException {
        return jdbcTemplate.query("select * from Customer",
                new CustomerRowMapper());
    }

    public static int updateCustomerById(final String[] para) throws SQLException {
        int ret = jdbcTemplate.update("update Customer set gender = ?, age = ?, income = ? where customer_id = ?",
                para,
                new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR,java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
        return ret;
    }

    //bug
    public static int addCustomer(final String[] para) throws SQLException {
        return jdbcTemplate.update("insert into Customer (address_id, customer_name,password, gender,age,income) values (?,?,?,?,?,?)",
                para,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.CHAR, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

    public static List<CustomerDBModel> SearchCustomer(final String name) throws SQLException {
        return jdbcTemplate.query("select * from Customer where customer_name like '%" + name + "%'",
                new CustomerRowMapper());

    }

    public static int deleteCustomerById(final String id) throws SQLException {
        int ret = jdbcTemplate.update("delete from Customer where customer_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
        return ret;
    }
}
