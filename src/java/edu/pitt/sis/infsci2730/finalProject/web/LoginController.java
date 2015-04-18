/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.AddressService;
import edu.pitt.sis.infsci2730.finalProject.service.CustomerService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
    public ModelAndView userpage(@PathVariable String userid) {
        
        CustomerService customerservice = new CustomerService();
        AddressService addressservice = new AddressService();
        
        try {
            CustomerDBModel c = customerservice.getCustomerById(userid);
            c.setAddress(addressservice.getAddressById(c.getAddress_id()+""));
            return new ModelAndView("customerProfile","customer",c);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("500");
        }
    }
}
