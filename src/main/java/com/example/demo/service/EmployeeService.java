package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deactivateEmployee(Long id);
}
