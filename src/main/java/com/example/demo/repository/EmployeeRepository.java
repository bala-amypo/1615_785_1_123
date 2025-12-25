package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Employee;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<EmployeeSkillRepository, Long> {
Optional<Employee> findByEmail(String email);

Employee save(Employee e);
}