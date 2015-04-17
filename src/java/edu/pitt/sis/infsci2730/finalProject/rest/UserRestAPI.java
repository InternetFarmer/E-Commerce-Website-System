/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rest;

import com.google.gson.Gson;
import edu.pitt.sis.infsci2730.finalProject.model.AddressDBModel;
import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.AddressService;
import edu.pitt.sis.infsci2730.finalProject.service.CustomerService;
import edu.pitt.sis.infsci2730.finalProject.viewModel.Customer;
import edu.pitt.sis.infsci2730.finalProject.web.LoginController;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/rest/users")
public class UserRestAPI {

  //登录
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

  //注册
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity<String> register(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
    byte[] requestBody = requestEntity.getBody();
    String str = new String(requestBody, "UTF-8");
    Gson gson = new Gson();
    Customer c = gson.fromJson(str, Customer.class);

    AddressDBModel address = c.getAddress();
    String[] para = {address.getCity(), address.getStreet(), address.getState_(), address.getZipCode()};
    AddressService addressService = new AddressService();

    HttpHeaders responseHeaders = new HttpHeaders();
    try {
      int addressDBModel = addressService.addAddress(para);
      if (addressDBModel == 0) {
        return new ResponseEntity<String>("-1", responseHeaders, HttpStatus.CREATED);
      } else {
        return new ResponseEntity<String>("1", responseHeaders, HttpStatus.CREATED);
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<String>("0", responseHeaders, HttpStatus.CREATED);
    }

  }

  //更新信息
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity<Customer> update(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
    byte[] requestBody = requestEntity.getBody();
    String str = new String(requestBody, "UTF-8");
    Gson gson = new Gson();
    Customer c = gson.fromJson(str, Customer.class);

  }
}
