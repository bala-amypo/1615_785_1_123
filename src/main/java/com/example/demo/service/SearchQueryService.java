package com.example.demo.service;

import com.example.demo.model.SearchQuery;
import com.example.demo.model.Employee;

import java.util.List;

public interface SearchQueryService {

    List<Employee> searchEmployees(List<String> skills, long minExperience);

    SearchQuery saveSearch(List<String> skills, long minExperience);

    List<SearchQuery> getAllSearches();
}
