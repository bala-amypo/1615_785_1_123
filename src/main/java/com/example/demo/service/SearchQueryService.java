package com.example.demo.service;

import com.example.demo.entity.Employee;
import java.util.List;

public interface SearchQueryService {
    List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId);
}
