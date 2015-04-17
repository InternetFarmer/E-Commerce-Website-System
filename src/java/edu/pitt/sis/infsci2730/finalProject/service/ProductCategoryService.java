/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.ProductCategoryDBModel;
import edu.pitt.sis.infsci2730.finalProject.dao.ProductCategoryDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yanyanzhou
 */
public class ProductCategoryService {

    public ProductCategoryDBModel getProductCategoryById(final String id) throws SQLException {
        return ProductCategoryDao.getProductCategoryById(id);
    }

    public List<ProductCategoryDBModel> getProductCategory() throws SQLException {
        return ProductCategoryDao.getProductCategory();
    }

    public int updateProductCategoryById(final String[] para) throws SQLException {
        return ProductCategoryDao.updateProductCategoryById(para);
    }

    public int addProductCategory(final String[] para) throws SQLException {
        return ProductCategoryDao.addProductCategory(para);
    }

    public int deleteProductCategoryById(final String id) throws SQLException {
        return ProductCategoryDao.deleteProductCategoryById(id);
    }
}
