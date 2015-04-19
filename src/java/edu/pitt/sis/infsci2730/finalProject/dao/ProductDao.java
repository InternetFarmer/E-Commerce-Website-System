/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.model.ProductDBModel;
import edu.pitt.sis.infsci2730.finalProject.model.ProductCategoryDBModel;
import edu.pitt.sis.infsci2730.finalProject.utils.ProductCategoryRowMapper;
import edu.pitt.sis.infsci2730.finalProject.utils.ProductRowMapper;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class ProductDao {

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //search products by id
    public static ProductDBModel GetProductByID(final String id) throws SQLException {
        return jdbcTemplate.queryForObject("select * from Product where product_id=?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new ProductRowMapper());
    }

    public static String GetProductCategoryNameById(final String id) throws SQLException {
        ProductCategoryDBModel pc = new ProductCategoryDBModel();
        pc = jdbcTemplate.queryForObject("select * from Product,Product_Category "
                + "where Product.category_id = Product_Category.category_id "
                + "and Product.product_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new ProductCategoryRowMapper());
        return pc.getCategory_name();
    }

    public static List<ProductDBModel> GetAllProduct() throws SQLException {
        return jdbcTemplate.query("select * from Product",
                new ProductRowMapper());
    }

    //search products by name
    public static List<ProductDBModel> GetProductByName(final String name) throws SQLException {
        return jdbcTemplate.query("select * from Product where product_name like '%" + name + "%'",
                new ProductRowMapper());
    }

    //search products by catagory_id
    public static List<ProductDBModel> GetProductByCategory(final String id) throws SQLException {
        return jdbcTemplate.query("select * from Product where category_id=?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new ProductRowMapper());
    }

    //search products by price
    public static List<ProductDBModel> GetProductByPrice(final String[] array) throws SQLException {
        return jdbcTemplate.query("select * from Product where price>=? and price<=?",
                array,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR},
                new ProductRowMapper());
    }

    //search product with multiply parameters (category,name,price)
    public static List<ProductDBModel> GetProduct(final String[] array) throws SQLException {
        String sql = "select * from Product where";
        if (!array[0].equals("")) {
            sql += " category_id = " + array[0] + " and";
        }
        if (!array[1].equals("")) {
            sql += " product_name like '%" + array[1] + "%' and";
        }
        if (!array[2].equals("")) {
            sql += " price >= " + array[2] + " and";
        }
        if (!array[3].equals("")) {
            sql += " price <= " + array[3] + " and";
        }
        sql = sql.substring(0, sql.length() - 3);
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    //insert products by id
    public static int InsertProduct(final String[] array) throws SQLException {
        return jdbcTemplate.update("insert into Product (product_name,inventory_amount,price,category_id,buying_price) values(?,?,?,?,?)",
                array,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

    //delete products by id
    public static int DeleteProductByID(final String id) throws SQLException {
        return jdbcTemplate.update("delete from Product where product_id=?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }

    //update products by id
    public static int UpdateProductByID(final String[] array) throws SQLException {
        return jdbcTemplate.update("update Product set product_name=?, inventory_amount=?,"
                + "price=?,category_id=?, buying_price=? where product_id=?",
                array,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

    public static int UpdateProductAmountById(final String[] array) throws SQLException {
        String sql = "update Product set inventory_amount= ? where product_id = ?";
        return jdbcTemplate.update(sql, array, new int[]{java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }
}
