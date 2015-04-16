/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rowMapper;

import edu.pitt.sis.infsci2730.finalProject.bean.ProductCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class ProductCategoryRowMapper implements RowMapper<ProductCategory> {
    
    public ProductCategory mapRow(ResultSet rs, int index) throws SQLException {
        ProductCategory productCategory = new ProductCategory();
        
        productCategory.setCategory_id(rs.getInt("CATEGORY_ID"));
        productCategory.setCategory_name(rs.getString("CATEGORY_NAME"));
        
        return productCategory;
    }
}
