package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.SkillCategoryService;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    @Override
    public String getCategoryName(Long id) {
        return "Default Skill Category";
    }
}
