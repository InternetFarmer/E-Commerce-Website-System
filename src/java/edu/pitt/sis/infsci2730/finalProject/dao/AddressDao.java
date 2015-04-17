/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.utils.AddressRowMapper;
import edu.pitt.sis.infsci2730.finalProject.model.AddressDBModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author yanyanzhou
 */
public class AddressDao {

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static AddressDBModel getAddressById(final String id) throws SQLException {
        String sql = "select * from Address where address_id = ?";
        List<AddressDBModel> list = jdbcTemplate.query(sql,
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
     * update AddressDBModel by a given id
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
     * add new AddressDBModel
     *
     * @param para
     * @return
     */
//    public static int addAddress(final String[] para) throws SQLException {
//        String sql = "insert into Address (city,street,state_,zipCode) values (?,?,?,?)";
//        return jdbcTemplate.update(sql,
//                para,
//                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR});
//    }

    public static Long addAddress(final String[] para) throws SQLException {

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            String sql = "insert into Address (city,street,state_,zipCode) values (?,?,?,?)";

            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, para[0]);
                ps.setString(2, para[1]);
                ps.setString(3, para[2]);
                ps.setString(4, para[3]);
                return ps;
            }
        }, holder);

        Long newPersonId = holder.getKey().longValue();

        return newPersonId;
    }

    /**
     * delete AddressDBModel by given Id
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
