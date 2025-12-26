package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.SearchQueryRecord;

import java.util.List;
public interface SearchQueryService {
    List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId);
    SearchQueryRecord getQueryById(Long id);
    List<SearchQueryRecord> getQueriesForUser(Long id);
    void saveQuery(SearchQueryRecord r);
}

