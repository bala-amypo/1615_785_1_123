package com.example.demo.service.impl;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    @Override
    public Skill createSkill(Skill skill) {
        skill.setActive(true);
        return repository.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill updated) {
        Skill skill = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        skill.setName(updated.getName());
        return repository.save(skill);
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill skill = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        skill.setActive(false);
        repository.save(skill);
    }
}
