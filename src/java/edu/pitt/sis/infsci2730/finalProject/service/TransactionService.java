/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.TransactionDBModel;
import edu.pitt.sis.infsci2730.finalProject.dao.TransactionDao;
import edu.pitt.sis.infsci2730.finalProject.utils.TransactionRowMapper;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author yanyanzhou
 */
public class TransactionService {

    //search transactions and records by transaction_id
    public TransactionDBModel GetTransactionByID(final String id) throws SQLException {
        return TransactionDao.GetTransactionByID(id);
    }

    //search transactions by customer_id
    public List<TransactionDBModel> GetTransactionByCustomerID(final String id) throws SQLException {
        return TransactionDao.GetTransactionByCustomerID(id);
    }

    //search transactions and records by customer_id
    public SqlRowSet GetTransaction(final String id) throws SQLException {
        return TransactionDao.GetTransaction(id);
    }

    public List<TransactionDBModel> GetAllTransaction() throws SQLException {
        return TransactionDao.GetAllTransaction();
    }

    public int GetTranactionTotalAmount(final String id) throws SQLException {
        SqlRowSet s = TransactionDao.GetTranactionTotalAmount(id);
        if(s.next()){
            return s.getInt(1);
        }
        return -1;
    }

    //search transactions by date (a period of time)
    public SqlRowSet GetTransactionByDate(final String[] array) throws SQLException {
        return TransactionDao.GetTransactionByDate(array);
    }

    //insert new transaction by Transaction_id
    public TransactionDBModel InsertTransactionByID(final String[] array) throws SQLException {
        return TransactionDao.InsertTransactionByID(array);
    }

    //delete transactions by id
    public int DeleteTransactionByID(final String id) throws SQLException {
        return TransactionDao.DeleteTransactionByID(id);
    }

    //update transactions by id
    public int UpdateTransactionByID(final String[] array) throws SQLException {
        return TransactionDao.UpdateTransactionByID(array);
    }
}
