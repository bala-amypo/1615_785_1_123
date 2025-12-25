package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillService {

    EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill);

    EmployeeSkill deactivateEmployeeSkill(long id);

    List<EmployeeSkill> getSkillsForEmployee(long employeeId);
}
