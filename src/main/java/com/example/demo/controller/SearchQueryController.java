package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @Autowired
    private SearchQueryService searchQueryService;

    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> searchEmployeesBySkills(
            @RequestBody List<String> skills,
            @RequestParam Long searcherId) {
        List<Employee> employees = searchQueryService.searchEmployeesBySkills(skills, searcherId);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/queries")
    public ResponseEntity<SearchQueryRecord> saveQuery(@RequestBody SearchQueryRecord query) {
        searchQueryService.saveQuery(query);
        return ResponseEntity.ok(query);
    }

    @GetMapping("/queries/{id}")
    public ResponseEntity<SearchQueryRecord> getQueryById(@PathVariable Long id) {
        SearchQueryRecord query = searchQueryService.getQueryById(id);
        return ResponseEntity.ok(query);
    }

    @GetMapping("/queries/user/{userId}")
    public ResponseEntity<List<SearchQueryRecord>> getQueriesForUser(@PathVariable Long userId) {
        List<SearchQueryRecord> queries = searchQueryService.getQueriesForUser(userId);
        return ResponseEntity.ok(queries);
    }
}