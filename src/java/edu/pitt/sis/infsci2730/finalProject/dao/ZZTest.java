/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.bean.Record;
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
            RecordDao dao = (RecordDao) ac.getBean("recordDao");

//            String[] a={"2","1","5","20"};
//            String[] b={"2","2","3","15"};
//            System.out.println(dao.InsertRecordByTransactionIDAndProductId(a));
//            System.out.println(dao.InsertRecordByTransactionIDAndProductId(b));
            List<Record> list=dao.GetRecordByTransactionID("1");
            for(Record r:list){
                System.out.println("GetRecordByTransactionID "+r.getProduct_id());
            }
            
            List<Record> list2=dao.GetRecordByProductID("1");
            for(Record r:list2){
                System.out.println("GetRecordByProductID "+r.getProduct_id());
            }
            
            dao.UpdateRecordByTransactionIDAndProductID(new String[] {"3","80","2","2"});

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
