/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.utils;

import edu.pitt.sis.infsci2730.finalProject.model.TransactionDBModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class TransactionRowMapper implements RowMapper<TransactionDBModel> {
    
    public TransactionDBModel mapRow(ResultSet rs, int index) throws SQLException {
        TransactionDBModel transaction = new TransactionDBModel();
        
        transaction.setTransaction_id(rs.getInt("TRANSACTION_ID"));
        transaction.setTransaction_date(rs.getTimestamp("TRANSACTION_DATE"));
        transaction.setCustomer_id(rs.getInt("CUSTOMER_ID"));
//        transaction.setSalesperson_id(rs.getInt("SALESPERSON_ID"));
                
        return transaction;
    }
}
