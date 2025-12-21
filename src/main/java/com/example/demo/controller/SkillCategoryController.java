package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skill-categories")
@Tag(name = "Skill Category Controller")
public class SkillCategoryController {

    @PostMapping
    public String createCategory() {
        return "Category created";
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Long id) {
        return "Category updated";
    }

    @GetMapping("/{id}")
    public String getCategory(@PathVariable Long id) {
        return "Category fetched";
    }

    @GetMapping
    public String listCategories() {
        return "All categories listed";
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        return "Category deactivated";
    }
}
