package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @Autowired
    private SearchQueryService service;

    @PostMapping
    public List<Employee> search(
            @RequestBody List<String> skills,
            @RequestParam long minExperience
    ) {
        return service.searchEmployees(skills, minExperience);
    }

    @GetMapping
    public List<SearchQuery> getAllSearches() {
        return service.getAllSearches();
    }
}
