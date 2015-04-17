/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.viewModel;

import edu.pitt.sis.infsci2730.finalProject.model.*;
import java.io.Serializable;

/**
 *
 * @author Wu
 */

public class ProductCategory implements Serializable {
    
    private int category_id;
    private String category_name;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
