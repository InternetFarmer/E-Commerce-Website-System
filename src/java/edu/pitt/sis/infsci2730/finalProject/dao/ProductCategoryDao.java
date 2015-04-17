/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.utils.ProductCategoryRowMapper;
import edu.pitt.sis.infsci2730.finalProject.model.ProductCategoryDBModel;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class ProductCategoryDao {

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * get Product_Category only by id
     *
     * @param id
     * @return Product Category
     */
    public static ProductCategoryDBModel getProductCategoryById(final String id) throws SQLException {
        String sql = "select * from Product_Category where category_id = ?";
        List<ProductCategoryDBModel> list = jdbcTemplate.query(sql,
                new Object[]{id},
                new int[]{java.sql.Types.VARCHAR},
                new ProductCategoryRowMapper());
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public static List<ProductCategoryDBModel> getProductCategory() throws SQLException {
        String sql = "select * from Product_Category";
        List<ProductCategoryDBModel> list = jdbcTemplate.query(sql, new ProductCategoryRowMapper());
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * update Product_Category by a given id
     *
     * @param para
     * @return int
     */
    public static int updateProductCategoryById(final String[] para) throws SQLException {
        String sql = "update Product_Category set category_name = ? where category_id = ?";
        return jdbcTemplate.update(sql,
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
    }

    /**
     * add new Product_Category
     *
     * @param para
     * @return ProductCategoryDBModel
     */
    public static int addProductCategory(final String[] para) throws SQLException {
        String sql = "insert into Product_Category (category_name) values (?)";
        return jdbcTemplate.update(sql, para, new int[]{java.sql.Types.VARCHAR});
    }

    /**
     * delete Product_Category by a given id
     *
     * @param id
     * @return int
     */
    public static int deleteProductCategoryById(final String id) throws SQLException {
        String sql = "delete from Product_Category where category_id = ?";
        return jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }
}
