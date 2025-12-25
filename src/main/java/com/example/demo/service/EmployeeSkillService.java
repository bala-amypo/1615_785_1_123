package com.example.demo.service;

import com.example.demo.entity.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {
    List<EmployeeSkill> getSkillsByEmployee(Long employeeId);
}
