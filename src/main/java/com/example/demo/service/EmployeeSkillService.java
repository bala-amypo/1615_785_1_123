package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillService {

    EmployeeSkill addSkillToEmployee(Long employeeId, Long skillId, int proficiency);

    List<EmployeeSkill> getSkillsByEmployee(Long employeeId);

    List<EmployeeSkill> getEmployeesBySkill(Long skillId);

    void removeSkillFromEmployee(Long employeeSkillId);
}
