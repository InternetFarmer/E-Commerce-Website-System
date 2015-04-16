/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rowMapper;

import edu.pitt.sis.infsci2730.finalProject.bean.Record;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class RecordRowMapper implements RowMapper<Record> {
    
    public Record mapRow(ResultSet rs, int index) throws SQLException {
        Record record = new Record();
        
        record.setTransaction_id(rs.getInt("TRANSACTION_ID"));
        record.setProduct_id(rs.getInt("PRODUCT_ID"));
        record.setAmount(rs.getInt("AMOUNT"));
        record.setPrice(rs.getInt("PRICE"));
        
        return record;
    }
}
