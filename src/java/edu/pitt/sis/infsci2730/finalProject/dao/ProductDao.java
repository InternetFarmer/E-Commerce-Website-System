/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.bean.Product;
import edu.pitt.sis.infsci2730.finalProject.bean.ProductCategory;
import edu.pitt.sis.infsci2730.finalProject.rowMapper.ProductCategoryRowMapper;
import edu.pitt.sis.infsci2730.finalProject.rowMapper.ProductRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class ProductDao {

    private JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //search products by id
    public Product GetProductByID(String id) {
        return jdbcTemplate.queryForObject("select * from Product where product_id=?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new ProductRowMapper());
    }

    public String GetProductCategoryNameById(String id) {
        ProductCategory pc = new ProductCategory();
        pc = jdbcTemplate.queryForObject("select * from Product,Product_Category "
                + "where Product.category_id = Product_Category.category_id "
                + "and Product.product_id = ?",
                new Object[] {id},
                new int[] {java.sql.Types.INTEGER},
                new ProductCategoryRowMapper());
        return pc.getCategory_name();
    }

    public List<Product> GetAllProduct() {
        return jdbcTemplate.query("select * from Product",
                new ProductRowMapper());
    }

    //search products by name
    public List<Product> GetProductByName(String name) {
        return jdbcTemplate.query("select * from Product where product_name like '%" + name + "%'",
                new ProductRowMapper());
    }

    //search products by catagory_id
    public List<Product> GetProductByCategory(String id) {
        return jdbcTemplate.query("select * from Product where category_id=?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new ProductRowMapper());
    }

    //search products by price
    public List<Product> GetProductByPrice(String[] array) {
        return jdbcTemplate.query("select * from Product where price>=? and price<=?",
                array,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR},
                new ProductRowMapper());
    }

    //search product with multiply parameters (category,name,price)
    public List<Product> GetProduct(String[] array) {
        return jdbcTemplate.query("select * from Product where category_id =? and product_name like '%" + array[1] + "%' and price>=? and price<=?",
                new Object[]{array[0], array[2], array[3]},
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR},
                new ProductRowMapper());
    }

    //insert products by id
    public int InsertProduct(String[] array) {
        return jdbcTemplate.update("insert into Product (product_name,inventory_amount,price,category_id,buying_price) values(?,?,?,?,?)",
                array,
                new int[] {java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER});
    }

    //delete products by id
    public int DeleteProductByID(String id) {
        return jdbcTemplate.update("delete from Product where product_id=?", 
                new Object[] {id}, 
                new int[] {java.sql.Types.INTEGER});
    }

    //update products by id
    public int UpdateProductByID(String[] array) {
        return jdbcTemplate.update("update Product set product_name=?, inventory_amount=?,"
                + "price=?,category_id=?, buying_price=? where product_id=?", 
                array, 
                new int[] {java.sql.Types.VARCHAR,java.sql.Types.INTEGER,java.sql.Types.INTEGER,java.sql.Types.INTEGER,java.sql.Types.INTEGER,java.sql.Types.INTEGER});
    }

    public int UpdateProductAmountById(String[] array) {
        String sql = "update Product set inventory_amount= ? where product_id = ?";
        return jdbcTemplate.update(sql, array, new int[]{java.sql.Types.INTEGER,java.sql.Types.INTEGER});
    }
}
