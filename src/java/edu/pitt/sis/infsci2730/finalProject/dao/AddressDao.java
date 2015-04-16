/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.rowMapper.AddressRowMapper;
import edu.pitt.sis.infsci2730.finalProject.bean.Address;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class AddressDao {

    private JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Address getAddressById(String id) {
        String sql = "select * from Address where address_id = ?";
        List<Address> list = jdbcTemplate.query(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new AddressRowMapper());
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * update Address by a given id
     *
     * @param para
     * @return
     */
    public int updateAddressById(String[] para) {
        String sql = "update Address set state_ = ?, city = ?,street = ?, zipCode = ? where "
                + "address_id = ?";
        return jdbcTemplate.update(sql, para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
    }

    /**
     * add new Address
     *
     * @param para
     * @return
     */
    public int addAddress(String[] para) {
        String sql = "insert into Address (city,street,state_,zipCode) values (?,?,?,?)";
        return jdbcTemplate.update(sql, 
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR});
    }

    /**
     * delete Address by given Id
     *
     * @param id
     * @return
     */
    public int deleteAddressById(String id) {
        String sql = "delete from Address where address_id = ?";
        return jdbcTemplate.update(sql, 
                new Object[] {id}, 
                new int[] {java.sql.Types.INTEGER});
    }
}
