package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;
public interface SkillService {
    Skill createSkill(Skill s);
    Skill updateSkill(Long id, Skill s);
    void deactivateSkill(Long id);
}
