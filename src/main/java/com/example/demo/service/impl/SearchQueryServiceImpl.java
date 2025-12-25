package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final EmployeeSkillRepository employeeSkillRepo;

    public SearchQueryServiceImpl(EmployeeSkillRepository employeeSkillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {
        return employeeSkillRepo.findEmployeesByAllSkillNames(
                skills,
                searcherId,
                skills.size()
        );
    }
}
