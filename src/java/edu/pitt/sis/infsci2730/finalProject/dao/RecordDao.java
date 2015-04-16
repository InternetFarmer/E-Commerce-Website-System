/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.bean.Record;
import edu.pitt.sis.infsci2730.finalProject.rowMapper.RecordRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class RecordDao {

    private JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //search record by transaction_id
    public List<Record> GetRecordByTransactionID(String id) {
        String sql = "select * from Record where transaction_id=?";
        return jdbcTemplate.query(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new RecordRowMapper());
    }

    //search record by product_id
    public List<Record> GetRecordByProductID(String id) {
        String sql = "select * from Record where product_id=?";
        return jdbcTemplate.query(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new RecordRowMapper());
    }

    //insert new record by transaction_id
    public int InsertRecordByTransactionIDAndProductId(String[] array) {
        String sql = "insert into Record values(?,?,?,?)";//transaction_id,product_id,amount,price
        return jdbcTemplate.update(sql, array,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

    //delete records by transaction_id
    public int DeleteRecordByTransactionID(String id) {
        String sql = "delete from Record where transaction_id=?";
        return jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new RecordRowMapper());
    }

    //delete records by product_id
    public int DeleteRecordByProductID(String id) {
        String sql = "delete from Record where product_id=?";
        return jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }

    //update records by transaction_id and product_id
    public int UpdateRecordByTransactionIDAndProductID(String[] array) {
        String sql = "update Record set amount=?,price=? "
                + "where transaction_id=? and product_id=?";
        return jdbcTemplate.update(sql,
                array,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

}
