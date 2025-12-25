package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
public interface EmployeeSkillService {
    EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill);
    EmployeeSkill deactivateEmployeeSkill(long id);
    List<EmployeeSkill> getSkillsForEmployee(long employeeId);
}
