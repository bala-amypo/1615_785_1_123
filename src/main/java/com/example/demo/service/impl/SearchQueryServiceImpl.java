package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository recordRepo;
    private final EmployeeSkillRepository employeeSkillRepo;

    public SearchQueryServiceImpl(
            SearchQueryRecordRepository recordRepo,
            EmployeeSkillRepository employeeSkillRepo) {
        this.recordRepo = recordRepo;
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, long searcherId) {
        return employeeSkillRepo.findEmployeesByAllSkillNames(skills, searcherId);
    }

    @Override
    public SearchQueryRecord getQueryById(long id) {
        return recordRepo.findById(id).orElseThrow();
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(long searcherId) {
        return recordRepo.findBySearcherId(searcherId);
    }
}
