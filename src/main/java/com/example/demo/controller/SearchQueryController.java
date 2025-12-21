package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @PostMapping("/employees")
    public String searchEmployees(@RequestBody List<String> skills) {
        return "Employees searched by skills";
    }

    @GetMapping("/{id}")
    public String getQuery(@PathVariable Long id) {
        return "Query record fetched";
    }

    @GetMapping("/user/{userId}")
    public String listUserQueries(@PathVariable Long userId) {
        return "Past queries listed";
    }
}
