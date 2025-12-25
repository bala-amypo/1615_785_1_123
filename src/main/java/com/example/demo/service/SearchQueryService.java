package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;

public interface SearchQueryService {

    List<Employee> searchEmployeesBySkills(List<String> skills, long searcherId);

    SearchQueryRecord getQueryById(long id);

    List<SearchQueryRecord> getQueriesForUser(long searcherId);
}
