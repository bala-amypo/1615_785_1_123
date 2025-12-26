package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existing = getEmployeeById(id);

        existing.setFullName(updatedEmployee.getFullName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setSalary(updatedEmployee.getSalary());
        existing.setRole(updatedEmployee.getRole());
        existing.setActive(updatedEmployee.getActive());

        return employeeRepository.save(existing);
    }

    @Override
    public void deactivateEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        emp.setActive(false);
        employeeRepository.save(emp);
    }
}
