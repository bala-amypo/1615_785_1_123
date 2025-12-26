package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository repo;

    public SkillCategoryServiceImpl(SkillCategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return repo.save(category);
    }
}
