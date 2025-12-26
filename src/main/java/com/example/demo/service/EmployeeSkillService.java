package com.example.demo.service;

import com.example.demo.entity.EmployeeSkill;
import java.util.List;
public interface EmployeeSkillService {
    EmployeeSkill createEmployeeSkill(EmployeeSkill es);
    List<EmployeeSkill> getSkillsForEmployee(Long id);
    List<EmployeeSkill> getEmployeesBySkill(Long id);
    void deactivateEmployeeSkill(Long id);
}
