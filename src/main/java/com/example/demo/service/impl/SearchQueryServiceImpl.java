package com.example.demo.service.impl;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository queryRepo;
    private final EmployeeSkillRepository skillRepo;

    public SearchQueryServiceImpl(SearchQueryRecordRepository q, EmployeeSkillRepository s) {
        this.queryRepo = q;
        this.skillRepo = s;
    }

    public void saveQuery(SearchQueryRecord record) {
        queryRepo.save(record);
    }

    public SearchQueryRecord getQueryById(Long id) {
        return queryRepo.findById(id).orElse(null);
    }

    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return Collections.emptyList();
    }

    public List<String> searchEmployeesBySkills(List<String> skills, Long userId) {
        return Collections.emptyList();
    }
}
