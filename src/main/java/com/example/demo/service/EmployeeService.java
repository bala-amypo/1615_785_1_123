package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeSkillRepository;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeSkillRepository e);

    Employee updateEmployee(Long id, EmployeeSkillRepository e);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void deactivateEmployee(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);
}
