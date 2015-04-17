/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.dao;

import edu.pitt.sis.infsci2730.finalProject.bean.Employee;
import edu.pitt.sis.infsci2730.finalProject.rowMapper.EmployeeRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author yanyanzhou
 */
public class EmployeeDao {

    private static JdbcTemplate jdbcTemplate = null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * employee login check
     *
     * @param id
     * @param password
     * @return
     */
    public static Employee checkEmployee(final String id, final String password) {
        return jdbcTemplate.queryForObject("select * from Employee where employee_id = ? and password = ?",
                new Object[]{id, password},
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR},
                new EmployeeRowMapper());
    }

    /**
     * get Employee only by employee_id
     *
     * @param id
     * @return Employee
     */
    public static Employee getEmployeeById(final String id) {
        return jdbcTemplate.queryForObject("select * from Employee where employee_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER},
                new EmployeeRowMapper());
    }

    /**
     * get Employee only by employee_name
     *
     * @param name
     * @return List
     */
    public static List<Employee> getEmployeeByEmployeeName(final String name) {
        return jdbcTemplate.query("select * from Employee where employee_name like '%" + name + "%'",
                new EmployeeRowMapper());
    }

    public static List<Employee> getAllEmployees() {
        return jdbcTemplate.query("select * from Employee",
                new EmployeeRowMapper());
    }

    /**
     * update Employee Name by a given id
     *
     * @param para
     * @return
     */
    public static int updateEmployeeNameById(final String[] para) {
        int ret = jdbcTemplate.update("update Employee set employee_name = ? where employee_id = ?",
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
        return ret;
    }

    /**
     * add new Employee 
     *
     * @param para
     * @return Employee
     */
    public static int addEmployee(final String[] para) {
        return jdbcTemplate.update("insert into Employee (password,employee_name,address_id,"
                + "jobtitle,store_id,salary) values ('123456',?,?,?,?,?)",
                para,
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR});
    }

    /**
     * delete Employee by given Id
     *
     * @param id
     * @return int
     */
    public static int deleteEmployeeById(final String id) {
        int ret = jdbcTemplate.update("delete from Employee where employee_id = ?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
        return ret;
    }
}
