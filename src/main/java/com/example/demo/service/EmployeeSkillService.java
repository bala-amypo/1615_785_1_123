package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillService {

    EmployeeSkill addSkillToEmployee(long employeeId, long skillId, int proficiency);

    EmployeeSkill deactivateEmployeeSkill(long employeeSkillId);

    List<EmployeeSkill> getSkillsForEmployee(long employeeId);
}
