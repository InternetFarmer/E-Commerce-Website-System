/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.model.AddressDBModel;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author yanyanzhou
 */
public class ZZTest {

    public static void main(String[] args) throws Exception {
        try {
            ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
            AddressDao dao = (AddressDao) ac.getBean("addressDao");

            String[] a={"Pittsburgh","Fifth","PA","15213"};
//            String[] b={"2","2","3","15"};
            
            System.out.println(dao.addAddress(a));
//            System.out.println(dao.InsertRecordByTransactionIDAndProductId(b));
            
            
//            List<RecordDBModel> list=dao.GetRecordByTransactionID("1");
//            for(RecordDBModel r:list){
//                System.out.println("GetRecordByTransactionID "+r.getProduct_id());
//            }
//            
//            List<RecordDBModel> list2=dao.GetRecordByProductID("1");
//            for(RecordDBModel r:list2){
//                System.out.println("GetRecordByProductID "+r.getProduct_id());
//            }
            

//            System.out.println("GetTransaction");
//            SqlRowSet rows = dao.GetTransaction("5");
//            while(rows.next()){
//                System.out.println(rows.getInt(1)+" "+rows.getTimestamp(2)+" "+rows.getInt(4));
//            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
