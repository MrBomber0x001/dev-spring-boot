package com.meska.employee_rest.service;

import com.meska.employee_rest.entity.Employee;

import java.util.List;

public interface IEmployService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
