/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rest;

import edu.pitt.sis.infsci2730.finalProject.model.ProductDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.ProductService;
import edu.pitt.sis.infsci2730.finalProject.viewModel.Product;
import edu.pitt.sis.infsci2730.finalProject.web.LoginController;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/rest/products")
public class ProductRestAPI {
  //以下是RESTful API

//显示所有商品 GET
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<ProductDBModel> getAllProducts() throws UnsupportedEncodingException {

    ProductService productService = new ProductService();

    try {
      List<ProductDBModel> productList = productService.GetAllProduct();
      if (productList == null) {
        return null;
      } else {
        return productList;
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  //查询特定id 的商品 /{product_id} GET
  @RequestMapping(value = "/{product_id}", method = RequestMethod.GET)
  @ResponseBody
  public ProductDBModel getProductById(@RequestBody String product_id) throws UnsupportedEncodingException {
    
    ProductService productService = new ProductService();
    String para = (product_id);

    try {
      ProductDBModel productDBModel = productService.GetProductByID(para);
      if (productDBModel == null) {
        return null;
      } else {
        return productDBModel;
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  //增加商品 输入json return json PUT
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
  @ResponseBody
  public Product addProduct(@RequestBody Product p) throws UnsupportedEncodingException {

    ProductService productService = new ProductService();
    String[] para
            = {p.getProduct_name(),
              "'" + p.getInventory_amount() + "'",
              "'" + p.getPrice() + "'",
              "'" + p.getCategory_id() + "'",
              "'" + p.getBuying_price() + "'"};

    try {
      int addProduct = productService.InsertProduct(para);
      if (addProduct == 0) {
        return null;
      } else {
        return p;
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  //修改商品 输入json return json POST
  @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
  @ResponseBody
  public Product updateProduct(@RequestBody Product p) throws UnsupportedEncodingException {

    ProductService productService = new ProductService();
    String[] para
            = {p.getProduct_name(),
              "'" + p.getInventory_amount() + "'",
              "'" + p.getPrice() + "'",
              "'" + p.getCategory_id() + "'",
              "'" + p.getBuying_price() + "'",
              "'" + p.getProduct_id() + "'"};

    try {
      int updateProduct = productService.UpdateProductByID(para);
      if (updateProduct == 0) {
        return null;
      } else {
        return p;
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  //删除特定id的商品 /{product_id} DELETE
  @RequestMapping(value = "/{product_id}", method = RequestMethod.DELETE)
  @ResponseBody
  public String deleteProduct(@PathVariable String product_id) throws UnsupportedEncodingException {
    ProductService productService = new ProductService();
    String para = (product_id);
    try {
      int deleteProduct = productService.DeleteProductByID(para);
      if (deleteProduct == 0) {
        return "-1";
      } else {
        return "1";
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return "0";
    }
  }

}
