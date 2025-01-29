package com.meska.employee_rest.repository;

import com.meska.employee_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it, we can extend if we need to later with custom queries
}
