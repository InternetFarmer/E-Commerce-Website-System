/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.service.ProductService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/products")
public class ProductsController {
    
    private ProductService productService = new ProductService();
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            Map<String, Object> myModel = new HashMap<String, Object>();
            myModel.put("productList", this.productService.GetAllProduct());
            
            return new ModelAndView("products", "model", myModel);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("500");
        }
    }

    public void setProductManager(ProductService productService) {
        this.productService = productService;
    }
    
    
    
    
}
