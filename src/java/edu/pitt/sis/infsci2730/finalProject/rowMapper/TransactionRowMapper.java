/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rowMapper;

import edu.pitt.sis.infsci2730.finalProject.bean.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class TransactionRowMapper implements RowMapper<Transaction> {
    
    public Transaction mapRow(ResultSet rs, int index) throws SQLException {
        Transaction transaction = new Transaction();
        
        transaction.setTransaction_id(rs.getInt("TRANSACTION_ID"));
        transaction.setTransaction_date(rs.getTimestamp("TRANSACTION_DATE"));
        transaction.setCustomer_id(rs.getInt("CUSTOMER_ID"));
//        transaction.setSalesperson_id(rs.getInt("SALESPERSON_ID"));
                
        return transaction;
    }
}
