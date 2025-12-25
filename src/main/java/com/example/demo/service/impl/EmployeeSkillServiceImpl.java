package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepo;
    private final EmployeeRepository employeeRepo;
    private final SkillRepository skillRepo;

    public EmployeeSkillServiceImpl(
            EmployeeSkillRepository employeeSkillRepo,
            EmployeeRepository employeeRepo,
            SkillRepository skillRepo
    ) {
        this.employeeSkillRepo = employeeSkillRepo;
        this.employeeRepo = employeeRepo;
        this.skillRepo = skillRepo;
    }

    // ✅ ADD SKILL TO EMPLOYEE
    @Override
    public EmployeeSkill addSkillToEmployee(long employeeId, long skillId, int proficiency) {

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Skill skill = skillRepo.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        EmployeeSkill employeeSkill = new EmployeeSkill();
        employeeSkill.setEmployee(employee);
        employeeSkill.setSkill(skill);
        employeeSkill.setProficiency(proficiency);
        employeeSkill.setActive(true);

        return employeeSkillRepo.save(employeeSkill);
    }

    // ✅ FIXED METHOD (THIS WAS YOUR LAST ERROR)
    @Override
    public List<EmployeeSkill> getSkillsForEmployee(long employeeId) {
        return employeeSkillRepo.findByEmployee_Id(employeeId);
    }

    // ✅ DEACTIVATE SKILL
    @Override
    public void deactivateEmployeeSkill(long employeeSkillId) {
        EmployeeSkill es = employeeSkillRepo.findById(employeeSkillId)
                .orElseThrow(() -> new RuntimeException("EmployeeSkill not found"));

        es.setActive(false);
        employeeSkillRepo.save(es);
    }
}
