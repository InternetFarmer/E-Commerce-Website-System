/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.AddressDBModel;
import edu.pitt.sis.infsci2730.finalProject.dao.AddressDao;

/**
 *
 * @author yanyanzhou
 */
public class AddressService {

    public AddressDBModel getAddressById(final String id) {
        return AddressDao.getAddressById(id);
    }

    public int updateAddressById(final String[] para) {
        return AddressDao.updateAddressById(para);
    }

    public int addAddress(final String[] para) {
        return AddressDao.addAddress(para);
    }

    public int deleteAddressById(final String id) {
        return AddressDao.deleteAddressById(id);
    }
}
