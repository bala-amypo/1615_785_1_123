package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {

    Employee updateEmployee(Long id, Employee employee);

    Employee getEmployeeById(Long id);

    void deactivateEmployee(Long id);
}
