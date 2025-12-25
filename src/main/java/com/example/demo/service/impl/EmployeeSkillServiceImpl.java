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
            SkillRepository skillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
        this.employeeRepo = employeeRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public EmployeeSkill addSkillToEmployee(long employeeId, long skillId, int proficiency) {

        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        Skill skill = skillRepo.findById(skillId).orElseThrow();

        EmployeeSkill employeeSkill = new EmployeeSkill();
        employeeSkill.setEmployee(employee);
        employeeSkill.setSkill(skill);
        employeeSkill.setProficiency(proficiency);
        employeeSkill.setActive(true);

        return employeeSkillRepo.save(employeeSkill);
    }

    @Override
    public EmployeeSkill deactivateEmployeeSkill(long employeeSkillId) {
        EmployeeSkill es = employeeSkillRepo.findById(employeeSkillId).orElseThrow();
        es.setActive(false);
        return employeeSkillRepo.save(es);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(long employeeId) {
        return employeeSkillRepo.findByEmployeeId(employeeId);
    }
}
