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

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //search record by transaction_id
    public static List<Record> GetRecordByTransactionID(final String id) {
        String sql = "select * from Record where transaction_id=?";
        return jdbcTemplate.query(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new RecordRowMapper());
    }

    //search record by product_id
    public static List<Record> GetRecordByProductID(final String id) {
        String sql = "select * from Record where product_id=?";
        return jdbcTemplate.query(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new RecordRowMapper());
    }

    //insert new record by transaction_id
    public static int InsertRecordByTransactionIDAndProductId(final String[] array) {
        String sql = "insert into Record values(?,?,?,?)";//transaction_id,product_id,amount,price
        return jdbcTemplate.update(sql, array,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

    //delete records by transaction_id
    public static int DeleteRecordByTransactionID(final String id) {
        String sql = "delete from Record where transaction_id=?";
        return jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new RecordRowMapper());
    }

    //delete records by product_id
    public static int DeleteRecordByProductID(final String id) {
        String sql = "delete from Record where product_id=?";
        return jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }

    //update records by transaction_id and product_id
    public static int UpdateRecordByTransactionIDAndProductID(final String[] array) {
        String sql = "update Record set amount=?,price=? "
                + "where transaction_id=? and product_id=?";
        return jdbcTemplate.update(sql,
                array,
                new int[]{java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

}
