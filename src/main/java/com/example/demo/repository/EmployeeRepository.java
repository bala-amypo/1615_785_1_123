package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Employee;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
Optional<Employee> findByEmail(String email);
}