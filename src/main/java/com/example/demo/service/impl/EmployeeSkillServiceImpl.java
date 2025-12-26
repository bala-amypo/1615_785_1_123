package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import com.example.demo.entity.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepo;
    private final EmployeeRepository employeeRepo;
    private final SkillRepository skillRepo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepo,
                                    EmployeeRepository employeeRepo,
                                    SkillRepository skillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
        this.employeeRepo = employeeRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {

        if (es.getYearsOfExperience() < 0) {
            throw new IllegalArgumentException("Invalid experience");
        }

        if (!List.of("Beginner", "Intermediate", "Advanced")
                .contains(es.getProficiencyLevel())) {
            throw new IllegalArgumentException("Invalid proficiency");
        }

        Employee employee = employeeRepo.findById(es.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Skill skill = skillRepo.findById(es.getSkill().getId())
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        if (!employee.getActive()) {
            throw new IllegalArgumentException("Employee inactive");
        }

        if (!skill.getActive()) {
            throw new IllegalArgumentException("Skill inactive");
        }

        return employeeSkillRepo.save(es);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return employeeSkillRepo.findByEmployeeIdAndActiveTrue(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return employeeSkillRepo.findBySkillIdAndActiveTrue(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill es = employeeSkillRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeSkill not found"));
        es.setActive(false);
        employeeSkillRepo.save(es);
    }
}
