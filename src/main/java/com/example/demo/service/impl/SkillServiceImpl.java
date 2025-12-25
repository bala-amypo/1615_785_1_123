package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    @Override
    public Skill createSkill(Skill skill) {
        return repo.save(skill);
    }
}
