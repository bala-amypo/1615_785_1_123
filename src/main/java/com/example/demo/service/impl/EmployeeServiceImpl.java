package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    @Override
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
}
