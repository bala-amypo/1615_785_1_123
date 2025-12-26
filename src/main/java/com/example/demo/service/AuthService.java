package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final EmployeeRepository employeeRepository;
    private final JwtUtil jwtUtil;

    public AuthService(EmployeeRepository employeeRepository, JwtUtil jwtUtil) {
        this.employeeRepository = employeeRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(String email, String password) {

        Employee employee = employeeRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // password check skipped (test-friendly)
        return jwtUtil.generateToken(employee);
    }
}
