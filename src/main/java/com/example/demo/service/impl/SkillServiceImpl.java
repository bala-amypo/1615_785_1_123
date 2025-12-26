package com.example.demo.service.impl;

import com.example.demo.entity.Skill;
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

    public Skill createSkill(Skill s) {
        s.setActive(true);
        return repo.save(s);
    }

    public Skill updateSkill(Long id, Skill s) {
        Skill existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        existing.setName(s.getName());
        return repo.save(existing);
    }

    public Skill deactivateSkill(Long id) {
        Skill s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        s.setActive(false);
        return repo.save(s);
    }
}
