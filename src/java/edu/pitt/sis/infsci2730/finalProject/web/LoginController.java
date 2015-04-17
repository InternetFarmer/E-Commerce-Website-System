/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("/index")
public class LoginController {

    @RequestMapping("/login")
    public void login(@RequestParam(value="id") Integer id) {
        

    }
    
    @RequestMapping("/signup")
    public void signup(@RequestParam(value="id") Integer id) {

    }
}
