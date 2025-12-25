package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import org.springframework.stereotype.Service;
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

