/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.dao.ProductDao;
import edu.pitt.sis.infsci2730.finalProject.model.ProductDBModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yanyanzhou
 */
public class ProductService {

    //search products by id
    public ProductDBModel GetProductByID(final String id) throws SQLException {
        return ProductDao.GetProductByID(id);
    }

    public String GetProductCategoryNameById(final String id) throws SQLException {
        return ProductDao.GetProductCategoryNameById(id);
    }

    public List<ProductDBModel> GetAllProduct() throws SQLException {
        return ProductDao.GetAllProduct();
    }

    //search products by name
    public List<ProductDBModel> GetProductByName(final String name) throws SQLException {
        return ProductDao.GetProductByName(name);
    }

    //search products by catagory_id
    public List<ProductDBModel> GetProductByCategory(final String id) throws SQLException {
        return ProductDao.GetProductByCategory(id);
    }

    //search products by price
    public List<ProductDBModel> GetProductByPrice(final String[] array) throws SQLException {
        return ProductDao.GetProductByPrice(array);
    }

    //search product with multiply parameters (category,name,price)
    public List<ProductDBModel> GetProduct(final String[] array) throws SQLException {
        return ProductDao.GetProduct(array);
    }

    //insert products by id
    public int InsertProduct(final String[] array) throws SQLException {
        return ProductDao.InsertProduct(array);
    }

    //delete products by id
    public int DeleteProductByID(final String id) throws SQLException {
        return ProductDao.DeleteProductByID(id);
    }

    //update products by id
    public static int UpdateProductByID(final String[] array) throws SQLException {
        return ProductDao.UpdateProductByID(array);
    }

    public static int UpdateProductAmountById(final String[] array) throws SQLException {
        return ProductDao.UpdateProductByID(array);
    }
}
