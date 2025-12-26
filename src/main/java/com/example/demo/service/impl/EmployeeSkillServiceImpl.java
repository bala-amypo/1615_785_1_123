package com.example.demo.service.impl;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        return repository.save(employeeSkill);
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill) {
        EmployeeSkill existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mapping not found"));

        existing.setLevel(employeeSkill.getLevel());
        existing.setActive(employeeSkill.isActive());

        return repository.save(existing);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return repository.findBySkillId(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill mapping = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mapping not found"));

        mapping.setActive(false);
        repository.save(mapping);
    }
}
