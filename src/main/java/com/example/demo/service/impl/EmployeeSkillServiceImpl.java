package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EmployeeSkillService;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository esRepo;
    private final EmployeeRepository empRepo;
    private final SkillRepository skillRepo;

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {

        Employee emp = empRepo.findById(es.getEmployee().getId()).orElseThrow();
        Skill skill = skillRepo.findById(es.getSkill().getId()).orElseThrow();

        if (!emp.getActive()) throw new IllegalArgumentException("inactive employee");
        if (!skill.getActive()) throw new IllegalArgumentException("inactive skill");
        if (es.getYearsOfExperience() < 0)
            throw new IllegalArgumentException("Experience years invalid");

        List<String> allowed = List.of("Beginner", "Intermediate", "Advanced");
        if (!allowed.contains(es.getProficiencyLevel()))
            throw new IllegalArgumentException("Invalid proficiency");

        return esRepo.save(es);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill es = esRepo.findById(id).orElseThrow();
        es.setActive(false);
        esRepo.save(es);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return esRepo.findByEmployeeIdAndActiveTrue(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return esRepo.findBySkillIdAndActiveTrue(skillId);
    }
}
