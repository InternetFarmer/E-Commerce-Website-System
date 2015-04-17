/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.model.Customer;
import edu.pitt.sis.infsci2730.finalProject.service.CustomerService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/index")
public class LoginController {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @RequestMapping
    public String page() {
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes="application/json",  produces="application/json")
    @ResponseBody
    public String login(@RequstBody View) {
        CustomerService customerservice = new CustomerService();
        
        try{
           Customer customer = customerservice.login(new String[] {});
           if(customer == null){
               return 
           }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
=======
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
    @RequestMapping("/login")
    public void login(@RequestParam(value="id") Integer id) {
        

    }
    
    @RequestMapping("/signup")
    public void signup(@RequestParam(value="id") Integer id) {

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
    }
}
