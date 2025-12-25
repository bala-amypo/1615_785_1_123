package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Skill;

public interface SkillService {

    Skill createSkill(Skill skill);

    Skill updateSkill(Long skillId, Skill skill);

    Skill getSkillById(Long skillId);

    List<Skill> getAllSkills();

    void deleteSkill(Long skillId);
}
