package com.example.demo.service;

import com.example.demo.model.SearchQueryRecord;
import java.util.List;

public interface SearchQueryService {

    void saveQuery(SearchQueryRecord record);

    SearchQueryRecord getQueryById(Long id);

    List<SearchQueryRecord> getQueriesForUser(Long userId);

    List<String> searchEmployeesBySkills(java.util.List<String> skills, Long userId);
}
