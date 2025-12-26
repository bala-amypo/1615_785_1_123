package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository searchQueryRepo;
    private final EmployeeSkillRepository employeeSkillRepo;

    public SearchQueryServiceImpl(SearchQueryRecordRepository searchQueryRepo,
                                  EmployeeSkillRepository employeeSkillRepo) {
        this.searchQueryRepo = searchQueryRepo;
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {

        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Skills cannot be empty");
        }

        List<String> normalized = skills.stream()
                .map(s -> s.trim().toLowerCase())
                .distinct()
                .toList();

        List<Employee> employees =
                employeeSkillRepo.findEmployeesByAllSkillNames(
                        normalized, normalized.size());

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(searcherId);
        record.setSkillsRequested(String.join(",", normalized));
        record.setResultsCount(employees.size());

        searchQueryRepo.save(record);

        return employees;
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return searchQueryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found"));
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long searcherId) {
        return searchQueryRepo.findBySearcherId(searcherId);
    }

    @Override
    public void saveQuery(SearchQueryRecord record) {
        searchQueryRepo.save(record);
    }
}
