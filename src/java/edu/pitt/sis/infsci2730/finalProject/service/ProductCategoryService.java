/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.bean.ProductCategory;
import edu.pitt.sis.infsci2730.finalProject.dao.ProductCategoryDao;
import java.util.List;

/**
 *
 * @author yanyanzhou
 */
public class ProductCategoryService {

    public ProductCategory getProductCategoryById(final String id) {
        return ProductCategoryDao.getProductCategoryById(id);
    }

    public List<ProductCategory> getProductCategory() {
        return ProductCategoryDao.getProductCategory();
    }

    public int updateProductCategoryById(final String[] para) {
        return ProductCategoryDao.updateProductCategoryById(para);
    }

    public int addProductCategory(final String[] para) {
        return ProductCategoryDao.addProductCategory(para);
    }

    public int deleteProductCategoryById(final String id) {
        return ProductCategoryDao.deleteProductCategoryById(id);
    }
}
