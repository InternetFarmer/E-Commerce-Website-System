/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.AddressService;
import edu.pitt.sis.infsci2730.finalProject.service.CustomerService;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wu
 */
@Controller
@SessionAttributes("customer")
@RequestMapping("/user")
public class UserController {

    CustomerService customerservice = new CustomerService();
    AddressService addressservice = new AddressService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mypage(HttpSession session) {
        CustomerDBModel customer = (CustomerDBModel) session.getAttribute("customer");
        if (customer == null) {
            return new ModelAndView("index");
        } else {
            return new ModelAndView("customerProfile", "customer", customer);
        }
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String check(@RequestBody CustomerDBModel c) throws UnsupportedEncodingException {

        String[] para = {c.getCustomer_name(), c.getPassword()};

        try {
            CustomerDBModel customerDBModel = customerservice.login(para);
            if (customerDBModel == null) {
                return "-1";
            } else {
                return "1";
            }
        } catch (EmptyResultDataAccessException e) {
            return "-1";
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam("customer") String customer, @RequestParam("password") String password, HttpSession session) throws UnsupportedEncodingException {

        String[] para = {customer, password};

        try {
            CustomerDBModel customerDBModel = customerservice.login(para);
            if (customerDBModel == null) {
                return new ModelAndView("index", "error", "password wrong");
            } else {
                customerDBModel.setAddress(addressservice.getAddressById(customerDBModel.getAddress_id() + ""));
                session.setAttribute("customer", customerDBModel);
                return new ModelAndView("customerProfile", "customer", customerDBModel);
            }
        } catch (EmptyResultDataAccessException e) {
            return new ModelAndView("index", "error", "password wrong");
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("500");
        }
    }

}
