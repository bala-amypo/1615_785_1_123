package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @PostMapping
    public String createSkill() {
        return "Skill created";
    }

    @PutMapping("/{id}")
    public String updateSkill(@PathVariable Long id) {
        return "Skill updated";
    }

    @GetMapping("/{id}")
    public String getSkill(@PathVariable Long id) {
        return "Skill fetched";
    }

    @GetMapping
    public String listSkills() {
        return "All skills listed";
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        return "Skill deactivated";
    }
}
