package com.example.demo.service;

import com.example.demo.entity.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill);

    List<EmployeeSkill> getSkillsByEmployee(Long employeeId);

    List<EmployeeSkill> getEmployeesBySkill(Long skillId);

    void deactivateEmployeeSkill(Long id);
}
