package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee getEmployeeByEmail(String email);
    List<Employee> getAllEmployees();
}
