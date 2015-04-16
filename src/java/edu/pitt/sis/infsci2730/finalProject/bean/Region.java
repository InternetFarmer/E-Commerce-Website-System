/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.bean;

import java.io.Serializable;

/**
 *
 * @author Wu
 */
public class Region implements Serializable {
    
    private int region_id;
    private String region_name;
    private int region_manager;

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getRegion_manager() {
        return region_manager;
    }

    public void setRegion_manager(int region_manager) {
        this.region_manager = region_manager;
    }
}
