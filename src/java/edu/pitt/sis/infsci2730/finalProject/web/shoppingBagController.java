/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/shoppingBag")
public class shoppingBagController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mypage(HttpSession session) {
        try {
            CustomerDBModel customer = (CustomerDBModel) session.getAttribute("customer");
            if (customer == null) {
                return new ModelAndView("index");
            } else {
                return new ModelAndView("shoppingBag", "customer", customer);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderHistoryController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("500");
        }
    }
}
