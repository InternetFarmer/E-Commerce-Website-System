/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.utils;

import edu.pitt.sis.infsci2730.finalProject.model.ProductDBModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class ProductRowMapper implements RowMapper<ProductDBModel> {
    
    public ProductDBModel mapRow(ResultSet rs, int index) throws SQLException {
        ProductDBModel product = new ProductDBModel();
        
        product.setProduct_id(rs.getInt("PRODUCT_ID"));
        product.setProduct_name(rs.getString("PRODUCT_NAME"));
        product.setInventory_amount(rs.getInt("INVENTORY_AMOUNT"));
        product.setPrice(rs.getInt("PRICE"));
        product.setCategory_id(rs.getInt("CATEGORY_ID"));
        product.setBuying_price(rs.getInt("BUYING_PRICE"));
        
        return product;
    }
}
