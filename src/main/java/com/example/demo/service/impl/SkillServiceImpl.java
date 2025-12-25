package com.example.demo.service.impl;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;
@Service
public class SkillServiceImpl implements SkillService {

    @Override
    public Skill createSkill(Skill skill) {
        return skill;
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        return skill;
    }

    @Override
    public void deactivateSkill(Long id) {
        // implementation
    }
}
