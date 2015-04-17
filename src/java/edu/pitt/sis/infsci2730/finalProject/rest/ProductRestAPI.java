/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rest;

import com.google.gson.Gson;
import edu.pitt.sis.infsci2730.finalProject.viewModel.Customer;
import edu.pitt.sis.infsci2730.finalProject.viewModel.Product;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public ResponseEntity<List<Product>> getAllProducts(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        byte[] requestBody = requestEntity.getBody();
        String str = new String(requestBody, "UTF-8");
        Gson gson = new Gson();
        Customer c = gson.fromJson(str, Customer.class);

    }
    //查询特定id 的商品 /{product_id} GET
    
    //增加商品 输入json return json PUT
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Product> add(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        byte[] requestBody = requestEntity.getBody();
        String str = new String(requestBody, "UTF-8");
        Gson gson = new Gson();
        Customer c = gson.fromJson(str, Customer.class);

    }
    //修改商品 输入json return json POST
    
    //删除特定id的商品 /{product_id} DELETE
}
