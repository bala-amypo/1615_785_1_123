package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.SearchQueryService;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final EmployeeSkillRepository employeeSkillRepo;

    public SearchQueryServiceImpl(EmployeeSkillRepository employeeSkillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(
            List<String> skillNames,
            long searcherId
    ) {
        return employeeSkillRepo.findEmployeesByAllSkillNames(skillNames, searcherId);
    }
}
