/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.utils;

import edu.pitt.sis.infsci2730.finalProject.model.ProductCategoryDBModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class ProductCategoryRowMapper implements RowMapper<ProductCategoryDBModel> {
    
    public ProductCategoryDBModel mapRow(ResultSet rs, int index) throws SQLException {
        ProductCategoryDBModel productCategory = new ProductCategoryDBModel();
        
        productCategory.setCategory_id(rs.getInt("CATEGORY_ID"));
        productCategory.setCategory_name(rs.getString("CATEGORY_NAME"));
        
        return productCategory;
    }
}
