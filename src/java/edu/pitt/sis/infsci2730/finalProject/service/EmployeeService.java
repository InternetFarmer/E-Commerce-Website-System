/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.infsci2730.finalProject.service;

import edu.pitt.sis.infsci2730.finalProject.model.Employee;
import edu.pitt.sis.infsci2730.finalProject.dao.EmployeeDao;
import java.util.List;

/**
 *
 * @author yanyanzhou
 */
public class EmployeeService {
    
    public Employee checkEmployee(final String id, final String password) {
        return EmployeeDao.checkEmployee(id, password);
    }
    
    public Employee getEmployeeById(final String id) {
        return EmployeeDao.getEmployeeById(id);
    }
    
    public List<Employee> getEmployeeByEmployeeName(final String name) {
        return EmployeeDao.getEmployeeByEmployeeName(name);
    }
    
    public List<Employee> getAllEmployees() {
        return EmployeeDao.getAllEmployees();
    }
    
    public int updateEmployeeNameById(final String[] para) {
        return EmployeeDao.updateEmployeeNameById(para);
    }
    
    public int addEmployee(final String[] para) {
        return EmployeeDao.addEmployee(para);
    }
    
    public int deleteEmployeeById(final String id) {
        return EmployeeDao.deleteEmployeeById(id);
    }
}
