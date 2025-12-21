package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
}
