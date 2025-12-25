package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee e = repo.findById(id).orElseThrow();
        e.setFullName(employee.getFullName());
        e.setEmail(employee.getEmail());
        return repo.save(e);
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void deactivateEmployee(Long id) {
        Employee e = repo.findById(id).orElseThrow();
        e.setActive(false);
        repo.save(e);
    }
}
