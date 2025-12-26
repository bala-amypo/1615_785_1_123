package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        employeeSkill.setActive(true);
        return employeeSkillRepo.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getSkillsByEmployee(Long employeeId) {
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
