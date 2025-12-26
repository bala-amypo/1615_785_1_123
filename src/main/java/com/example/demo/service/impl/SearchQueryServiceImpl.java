package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SearchQueryService;
import lombok.RequiredArgsConstructor;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository queryRepo;
    private final EmployeeSkillRepository esRepo;

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {

        if (skills == null || skills.isEmpty())
            throw new IllegalArgumentException("Skills list must not be empty");

        List<String> normalized = skills.stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        List<Employee> result =
                esRepo.findEmployeesByAllSkillNames(normalized, (long) normalized.size());

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(searcherId);
        record.setSkillsRequested(String.join(",", normalized));
        record.setResultsCount(result.size());

        queryRepo.save(record);
        return result;
    }

    @Override
    public void saveQuery(SearchQueryRecord record) {
        queryRepo.save(record);
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return queryRepo.findById(id).orElseThrow();
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return queryRepo.findBySearcherId(userId);
    }
}
