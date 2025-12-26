package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository searchQueryRecordRepository;
    private final EmployeeSkillRepository employeeSkillRepository;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repo,
                                  EmployeeSkillRepository esRepo) {
        this.searchQueryRecordRepository = repo;
        this.employeeSkillRepository = esRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {

        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Skill list must not be empty");
        }

        List<String> normalized = skills.stream()
                .map(s -> s.trim().toLowerCase(Locale.ROOT))
                .distinct()
                .collect(Collectors.toList());

        List<Employee> results =
                employeeSkillRepository.findEmployeesByAllSkillNames(
                        normalized, (long) normalized.size());

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(searcherId);
        record.setSkillsRequested(String.join(",", normalized));
        record.setResultsCount(results.size());

        searchQueryRecordRepository.save(record);

        return results;
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return searchQueryRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found"));
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long id) {
        return searchQueryRecordRepository.findBySearcherId(id);
    }

    @Override
    public void saveQuery(SearchQueryRecord record) {
        searchQueryRecordRepository.save(record);
    }
}
