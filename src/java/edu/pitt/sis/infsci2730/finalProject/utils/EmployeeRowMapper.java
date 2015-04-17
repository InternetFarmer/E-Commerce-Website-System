/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.utils;

import edu.pitt.sis.infsci2730.finalProject.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yanyanzhou
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    public Employee mapRow(ResultSet rs, int index) throws SQLException {
        Employee employee = new Employee();

        employee.setEmployee_id(rs.getInt("employee_id"));
        employee.setEmployee_name(rs.getString("employee_name"));
        employee.setAddress_id(rs.getInt("address_id"));
        employee.setStore_id(rs.getInt("store_id"));
        employee.setSalary(rs.getString("salary"));
        employee.setJobtitle(rs.getString("JOBTITLE"));

        return employee;
    }
}
