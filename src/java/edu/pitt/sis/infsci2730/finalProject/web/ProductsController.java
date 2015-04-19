/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.model.ProductDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.ProductCategoryService;
import edu.pitt.sis.infsci2730.finalProject.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService = new ProductService();
    private ProductCategoryService productCategoryService = new ProductCategoryService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView page() {
        try {
            Map<String, Object> myModel = new HashMap<String, Object>();
            List<ProductDBModel> list = this.productService.GetAllProduct();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ProductDBModel p = list.get(i);
                p.setCategory(this.productCategoryService.getProductCategoryById(p.getCategory_id()+""));
            }
            myModel.put("productList", list);
            myModel.put("productCategory", this.productCategoryService.getProductCategory());
            return new ModelAndView("products", "modelMap", myModel);
        } 
        catch (Exception ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("500");
        }
    }
}
