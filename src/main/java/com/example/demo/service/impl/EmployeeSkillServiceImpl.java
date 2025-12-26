package com.example.demo.service.impl;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository esRepo;
    private final EmployeeRepository empRepo;
    private final SkillRepository skillRepo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository e, EmployeeRepository emp, SkillRepository s) {
        this.esRepo = e;
        this.empRepo = emp;
        this.skillRepo = s;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {

        if (es.getYearsOfExperience() < 0)
            throw new IllegalArgumentException("Experience years invalid");

        if (!List.of("Beginner","Intermediate","Advanced").contains(es.getProficiencyLevel()))
            throw new IllegalArgumentException("Invalid proficiency");

        Employee emp = empRepo.findById(es.getEmployee().getId()).orElseThrow();
        Skill skill = skillRepo.findById(es.getSkill().getId()).orElseThrow();

        if (!emp.getActive()) throw new IllegalArgumentException("inactive employee");
        if (!skill.getActive()) throw new IllegalArgumentException("inactive skill");

        es.setActive(true);
        return esRepo.save(es);
    }

    public List<EmployeeSkill> getSkillsForEmployee(Long id) {
        return esRepo.findByEmployeeIdAndActiveTrue(id);
    }

    public List<EmployeeSkill> getEmployeesBySkill(Long id) {
        return esRepo.findBySkillIdAndActiveTrue(id);
    }

    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill es = esRepo.findById(id).orElseThrow();
        es.setActive(false);
        esRepo.save(es);
    }
}
