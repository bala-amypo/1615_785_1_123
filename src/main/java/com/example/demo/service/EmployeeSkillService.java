package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillService {

    EmployeeSkill addSkillToEmployee(
            long employeeId,
            long skillId,
            int proficiency
    );

    List<EmployeeSkill> getSkillsForEmployee(long employeeId);

    void deactivateEmployeeSkill(long employeeSkillId);
}
