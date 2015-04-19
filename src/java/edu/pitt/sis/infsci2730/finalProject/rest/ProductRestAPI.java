/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rest;

import edu.pitt.sis.infsci2730.finalProject.model.ProductDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.ProductCategoryService;
import edu.pitt.sis.infsci2730.finalProject.service.ProductService;
import edu.pitt.sis.infsci2730.finalProject.viewModel.Product;
import edu.pitt.sis.infsci2730.finalProject.web.UserController;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.tribes.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/rest/products")
public class ProductRestAPI {
    //以下是RESTful API

    private final ProductService productService = new ProductService();
    private final ProductCategoryService categoryService = new ProductCategoryService();

    //显示所有商品 GET
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDBModel> getAllProducts() throws UnsupportedEncodingException {

        try {
            List<ProductDBModel> productList = productService.GetAllProduct();
            if (productList == null) {
                return null;
            } else {
                return productList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //查询特定id 的商品 /{product_id} GET
    @RequestMapping(value = "/{product_id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ProductDBModel getProductById(@PathVariable String product_id) throws UnsupportedEncodingException {

        try {
            System.out.println(product_id);
            ProductDBModel productDBModel = productService.GetProductByID(product_id);
            if (productDBModel == null) {
                return null;
            } else {
                productDBModel.setCategory(this.categoryService.getProductCategoryById(productDBModel.getCategory_id() + ""));
                return productDBModel;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //增加商品 输入json return json PUT
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Product addProduct(@RequestBody Product p) throws UnsupportedEncodingException {

        String[] para
                = {p.getProduct_name(),
                    p.getInventory_amount() + "",
                    p.getPrice() + "",
                    p.getCategory_id() + "",
                    p.getBuying_price() + ""};

        try {
            int addProduct = productService.InsertProduct(para);
            if (addProduct == 0) {
                return null;
            } else {
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //修改商品 输入json return json POST
    @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Product updateProduct(@RequestBody Product p) throws UnsupportedEncodingException {

        String[] para
                = {p.getProduct_name(),
                    p.getInventory_amount() + "",
                    p.getPrice() + "",
                    p.getCategory_id() + "",
                    p.getBuying_price() + "",
                    p.getProduct_id() + ""};

        try {
            int updateProduct = productService.UpdateProductByID(para);
            if (updateProduct == 0) {
                return null;
            } else {
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //删除特定id的商品 /{product_id} DELETE
    @RequestMapping(value = "/{product_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProduct(@PathVariable String product_id) throws UnsupportedEncodingException {
        String para = (product_id);
        try {
            int deleteProduct = productService.DeleteProductByID(para);
            if (deleteProduct == 0) {
                return "-1";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    // search products
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDBModel> searchProduct(@RequestParam("product_id") String product_id,
            @RequestParam("product_name") String product_name,
            @RequestParam("product_category") String product_category,
            @RequestParam("price_from") String price_from,
            @RequestParam("price_to") String price_to) throws UnsupportedEncodingException, SQLException {
        List<ProductDBModel> list = new ArrayList<ProductDBModel>();
        if (!product_id.equals("")) {     // search by product ID
            ProductDBModel product = productService.GetProductByID(product_id);
            product.setCategory(this.categoryService.getProductCategoryById(product.getCategory_id()+""));
            list.add(product);
            return list;
        } else {  //search by product name and category
            if(product_category.equals("-1"))
                product_category = "";
            String[] para = {product_category, product_name, price_from, price_to};
            list = productService.GetProduct(para);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ProductDBModel p = list.get(i);
                p.setCategory(this.categoryService.getProductCategoryById(p.getCategory_id()+""));
            }
            return list;
        }

    }
}
