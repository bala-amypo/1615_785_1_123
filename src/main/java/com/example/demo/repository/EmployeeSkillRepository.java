package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillRepository
        extends JpaRepository<EmployeeSkill, Long> {
}
