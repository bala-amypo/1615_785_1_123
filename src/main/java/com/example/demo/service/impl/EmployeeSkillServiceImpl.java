package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository esRepo;
    private final EmployeeRepository empRepo;
    private final SkillRepository skillRepo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository esRepo,
                                    EmployeeRepository empRepo,
                                    SkillRepository skillRepo) {
        this.esRepo = esRepo;
        this.empRepo = empRepo;
        this.skillRepo = skillRepo;
    }

    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {
        if (es.getYearsOfExperience() < 0)
            throw new IllegalArgumentException("Experience years");

        if (!List.of("Beginner","Intermediate","Advanced")
                .contains(es.getProficiencyLevel()))
            throw new IllegalArgumentException("Invalid proficiency");

        Employee e = empRepo.findById(es.getEmployee().getId()).orElseThrow();
        Skill s = skillRepo.findById(es.getSkill().getId()).orElseThrow();

        if (!e.getActive()) throw new IllegalArgumentException("inactive employee");
        if (!s.getActive()) throw new IllegalArgumentException("inactive skill");

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
