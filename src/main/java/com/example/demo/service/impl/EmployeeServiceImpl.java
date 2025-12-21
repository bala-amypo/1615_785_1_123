package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

@Service   // ✅ REQUIRED
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee createEmployee(Employee e) {
        repo.findByEmail(e.getEmail())
            .ifPresent(x -> {
                throw new IllegalArgumentException("duplicate email");
            });
        return repo.save(e);
    }

    @Override
    public Employee updateEmployee(Long id, Employee e) {
        Employee emp = getEmployeeById(id);
        emp.setFullName(e.getFullName());
        emp.setDepartment(e.getDepartment());
        emp.setJobTitle(e.getJobTitle());
        return repo.save(emp);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public void deactivateEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        emp.setActive(false);
        repo.save(emp);
    }
}
