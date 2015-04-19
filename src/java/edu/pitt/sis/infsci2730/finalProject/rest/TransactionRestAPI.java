/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.rest;

import edu.pitt.sis.infsci2730.finalProject.model.CustomerDBModel;
import edu.pitt.sis.infsci2730.finalProject.model.RecordDBModel;
import edu.pitt.sis.infsci2730.finalProject.model.TransactionDBModel;
import edu.pitt.sis.infsci2730.finalProject.service.ProductService;
import edu.pitt.sis.infsci2730.finalProject.service.RecordService;
import edu.pitt.sis.infsci2730.finalProject.service.TransactionService;
import edu.pitt.sis.infsci2730.finalProject.web.UserController;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Yanyan
 */
@Controller
@RequestMapping("/rest/transaction")
public class TransactionRestAPI {

    private final RecordService recordService = new RecordService();
    private final TransactionService transactionService = new TransactionService();
    private final ProductService productService = new ProductService();

    // add transaction 
    @RequestMapping(value = "/checkout", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TransactionDBModel addTransaction(@RequestBody List<RecordDBModel> list, HttpSession session) throws SQLException {
        CustomerDBModel customer = (CustomerDBModel) session.getAttribute("customer");
        if (customer == null) {
            return null;
        }
        TransactionDBModel newTransaction = transactionService.InsertTransactionByID(new String[]{customer.getCustomer_id() + ""});
        for (RecordDBModel record : list) {
            try {
                String[] para = {newTransaction.getTransaction_id() + "",
                    record.getProduct_id() + "",
                    record.getAmount() + "",
                    record.getPrice() + ""};
                recordService.InsertRecordByTransactionIDAndProductId(para);
            } catch (SQLException ex) {
                Logger.getLogger(TransactionRestAPI.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return newTransaction;
    }

    // display records of a transaction
    @RequestMapping(value = "/records/{transaction_id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RecordDBModel> showRecords(@PathVariable String transaction_id, HttpSession session)
            throws UnsupportedEncodingException, SQLException {
        System.out.println(transaction_id);
        List<RecordDBModel> list = recordService.GetRecordByTransactionID(transaction_id);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            RecordDBModel r = list.get(i);
            r.setProduct(productService.GetProductByID(r.getProduct_id() + ""));
        }
        try {
            if (list != null) {
                return list;
            } else {
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
