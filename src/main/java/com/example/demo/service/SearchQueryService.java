package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface SearchQueryService {

    List<Employee> searchEmployeesBySkills(
            List<String> skillNames,
            long searcherId
    );
}
