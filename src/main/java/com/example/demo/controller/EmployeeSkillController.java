package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee-skills")
@Tag(name = "Employee Skill Controller")
public class EmployeeSkillController {

    @PostMapping
    public String createMapping() {
        return "Employee-Skill mapping created";
    }

    @PutMapping("/{id}")
    public String updateMapping(@PathVariable Long id) {
        return "Mapping updated";
    }

    @GetMapping("/employee/{employeeId}")
    public String listSkillsForEmployee(@PathVariable Long employeeId) {
        return "Skills for employee";
    }

    @GetMapping("/skill/{skillId}")
    public String listEmployeesWithSkill(@PathVariable Long skillId) {
        return "Employees with skill";
    }

    @PutMapping("/{id}/deactivate")
    public String deactivateMapping(@PathVariable Long id) {
        return "Mapping deactivated";
    }
}
