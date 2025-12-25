package com.example.demo.service.impl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        skill.setActive(true);
        return skillRepository.save(skill);
    }

    @Override
    public Skill deactivateSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow();
        skill.setActive(false);
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}
