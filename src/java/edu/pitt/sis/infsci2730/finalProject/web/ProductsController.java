/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.service.ProductCategoryService;
import edu.pitt.sis.infsci2730.finalProject.service.ProductService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/items")
public class ProductsController {

    private ProductService productService = new ProductService();
    private ProductCategoryService productCategoryService = new ProductCategoryService();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllProducts(HttpServletRequest request, HttpServletResponse response) {

        try {
            Map<String, Object> myModel = new HashMap<String, Object>();
            myModel.put("productList", this.productService.GetAllProduct());
            myModel.put("productCategory", this.productCategoryService.getProductCategory());
            return new ModelAndView("products", "modelMap", myModel);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("500");
        }
    }

    public void setProductService(final ProductService productService) {
        this.productService = productService;
    }
    
    public void setProductCategoryService(final ProductCategoryService productCategoryService){
        this.productCategoryService = productCategoryService;
    }
}
