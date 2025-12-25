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
    public List<EmployeeSkill> getSkillsByEmployee(Long employeeId) {
        return employeeSkillRepo.findByEmployee_Id(employeeId);
    }
}
