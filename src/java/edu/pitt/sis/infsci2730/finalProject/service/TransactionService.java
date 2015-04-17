/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.TransactionDBModel;
import edu.pitt.sis.infsci2730.finalProject.dao.TransactionDao;
import edu.pitt.sis.infsci2730.finalProject.utils.TransactionRowMapper;
import java.util.List;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author yanyanzhou
 */
public class TransactionService {

    //search transactions and records by transaction_id
    public TransactionDBModel GetTransactionByID(final String id) {
        return TransactionDao.GetTransactionByID(id);
    }

    //search transactions by customer_id
    public List<TransactionDBModel> GetTransactionByCustomerID(final String id) {
        return TransactionDao.GetTransactionByCustomerID(id);
    }

    //search transactions and records by customer_id
    public  SqlRowSet GetTransaction(final String id) {
        return TransactionDao.GetTransaction(id);
    }
    
    public List<TransactionDBModel> GetAllTransaction() {
        return TransactionDao.GetAllTransaction();
    }
    
    public static SqlRowSet GetTranactionTotalAmount(final String id) {
        return TransactionDao.GetTranactionTotalAmount(id);
    }

    //search transactions by date (a period of time)
    public static SqlRowSet GetTransactionByDate(final String[] array) {
        return TransactionDao.GetTransactionByDate(array);
    }

    //insert new transaction by Transaction_id
    public static int InsertTransactionByID(final String[] array) {
        return TransactionDao.InsertTransactionByID(array);
    }

    //delete transactions by id
    public static int DeleteTransactionByID(final String id) {
        return TransactionDao.DeleteTransactionByID(id);
    }

    //update transactions by id
    public static int UpdateTransactionByID(final String[] array) {
        return TransactionDao.UpdateTransactionByID(array);
    }
}
