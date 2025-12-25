package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
