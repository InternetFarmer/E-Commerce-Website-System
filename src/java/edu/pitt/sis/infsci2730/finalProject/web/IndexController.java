/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

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
@RequestMapping("/home")
public class IndexController {

<<<<<<< Updated upstream:src/java/edu/pitt/sis/infsci2730/finalProject/web/IndexController.java
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mypage(HttpSession session) {
        return new ModelAndView("index");
=======
    @RequestMapping("/login")
    public String page() {
        return "index";
>>>>>>> Stashed changes:src/java/edu/pitt/sis/infsci2730/finalProject/web/LoginController.java
    }
}
