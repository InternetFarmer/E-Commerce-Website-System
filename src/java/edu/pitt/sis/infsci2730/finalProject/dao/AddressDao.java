/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.utils.AddressRowMapper;
import edu.pitt.sis.infsci2730.finalProject.model.Address;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class AddressDao {

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static Address getAddressById(final String id) throws SQLException {
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
    public static int updateAddressById(final String[] para) throws SQLException {
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
    public static int addAddress(final String[] para) throws SQLException {
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
    public static int deleteAddressById(final String id) throws SQLException {
        String sql = "delete from Address where address_id = ?";
        return jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }
}
