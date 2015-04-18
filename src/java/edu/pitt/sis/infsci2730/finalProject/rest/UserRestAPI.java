/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rest;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/rest/users")
public class UserRestAPI {

  //登录
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public String login(@RequestBody Customer c) throws UnsupportedEncodingException {

    CustomerService customerService = new CustomerService();
    String[] para = {c.getCustomer_name(), c.getPassword()};

    try {
      CustomerDBModel customerDBModel = customerService.login(para);
      if (customerDBModel == null) {
        return "-1";
      } else {
        return "1";
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return "0";
    }
  }

  //注册
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public Customer register(@RequestBody Customer c) throws UnsupportedEncodingException {

    AddressDBModel address = c.getAddress();
    AddressService addressService = new AddressService();
    String[] para
            = {address.getCity(),
              address.getStreet(),
              address.getState_(),
              address.getZipCode()};

    try {
      long addressId = addressService.addAddress(para);
      if (addressId == 0) {
        return null;
      } else {
        CustomerService customerService = new CustomerService();
        String[] para2
                = {"'" + addressId + "'",
                  c.getCustomer_name(),
                  c.getPassword(),
                  c.getGender(),
                  c.getAge(),
                  c.getIncome()};

        try {
          int addCustomer = customerService.addCustomer(para2);
          if (addCustomer == 0) {
            return null;
          } else {
            return c;
          }
        } catch (SQLException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }

  }

  //更新信息
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ResponseBody
  public Customer update(@RequestBody Customer c) throws UnsupportedEncodingException {
    CustomerService customerService = new CustomerService();
    String[] pata = {c.getCustomer_name(), "'" + c.getCustomer_id() + "'"};
    try {
      int updateCustomer = customerService.updateCustomerNameById(pata);
      if (updateCustomer == 0) {
        return null;
      } else {
        return c;
      }
    } catch (SQLException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
}
