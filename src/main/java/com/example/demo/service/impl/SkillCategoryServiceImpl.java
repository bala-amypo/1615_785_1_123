package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository repository;

    public SkillCategoryServiceImpl(SkillCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return repository.save(category);
    }

    @Override
    public SkillCategory updateCategory(Long id, SkillCategory category) {
        SkillCategory existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setName(category.getName());
        existing.setActive(category.isActive());

        return repository.save(existing);
    }

    @Override
    public SkillCategory getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deactivateCategory(Long id) {
        SkillCategory category = getCategoryById(id);
        category.setActive(false);
        repository.save(category);
    }
}
