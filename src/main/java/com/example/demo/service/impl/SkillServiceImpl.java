package com.example.demo.service.impl;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        skill.setActive(true);
        return repo.save(skill);
    }

    @Override
    public Skill deactivateSkill(long id) {
        Skill skill = repo.findById(id).orElseThrow();
        skill.setActive(false);
        return repo.save(skill);
    }
}
