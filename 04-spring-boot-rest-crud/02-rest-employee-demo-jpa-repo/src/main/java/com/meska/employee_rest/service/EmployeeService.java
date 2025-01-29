package com.meska.employee_rest.service;

import com.meska.employee_rest.entity.Employee;
import com.meska.employee_rest.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService implements IEmployService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository theEmployeeDAO) {
        employeeRepository = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

//        return employeeRepository.findById(theId); // an error occured here, related to Optional feature introduced in Java 8
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Didn't find the employee id - " + theId);
        }

        return theEmployee;
    }

//    @Transactional (no need for transaction here as it will be handled by JpaRespository
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

//    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}

/**
 * // we'll only delegate the call to the DAo (remember - controller, service, repository)
 *         //other external logic will be used here, not the repo!
 *         // the repo is only for database operations
 */
