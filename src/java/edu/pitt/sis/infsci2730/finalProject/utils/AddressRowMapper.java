/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.utils;

import edu.pitt.sis.infsci2730.finalProject.model.AddressDBModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class AddressRowMapper implements RowMapper<AddressDBModel> {
        public AddressDBModel mapRow(ResultSet rs, int index) throws SQLException {
        AddressDBModel address = new AddressDBModel();
        
        address.setAddress_id(rs.getInt("address_id"));
        address.setCity(rs.getString("city"));
        address.setState_(rs.getString("state_"));
        address.setStreet(rs.getString("street"));
        address.setZipCode(rs.getString("zipCode"));
        
        return address;
    }
}
