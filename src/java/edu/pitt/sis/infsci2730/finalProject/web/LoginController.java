/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import com.google.gson.Gson;
import edu.pitt.sis.infsci2730.finalProject.viewModel.Customer;
import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.CustomerService;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping
    public String page() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        byte[] requestBody = requestEntity.getBody();
        String str = new String(requestBody, "UTF-8");
        Gson gson = new Gson();
        Customer c = gson.fromJson(str, Customer.class);

        CustomerService customerService = new CustomerService();
        String[] para = {c.getCustomer_name(), c.getPassword()};

        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            CustomerDBModel customerDBModel = customerService.login(para);
            if (customerDBModel == null) {
                return new ResponseEntity<String>("-1", responseHeaders, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("1", responseHeaders, HttpStatus.CREATED);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<String>("0", responseHeaders, HttpStatus.CREATED);
        }
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        byte[] requestBody = requestEntity.getBody();
        String str = new String(requestBody, "UTF-8");
        Gson gson = new Gson();
        Customer c = gson.fromJson(str, Customer.class);

        
    }
}
