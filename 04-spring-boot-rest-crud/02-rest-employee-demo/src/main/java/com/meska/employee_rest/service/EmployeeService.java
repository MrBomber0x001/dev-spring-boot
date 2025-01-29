package com.meska.employee_rest.service;

import com.meska.employee_rest.dao.EmployeeDao;
import com.meska.employee_rest.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeService implements IEmployService{

    private EmployeeDao employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDao theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}

/**
 * // we'll only delegate the call to the DAo (remember - controller, service, repository)
 *         //other external logic will be used here, not the repo!
 *         // the repo is only for database operations
 */
