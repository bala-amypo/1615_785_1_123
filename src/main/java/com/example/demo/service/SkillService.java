package com.example.demo.service;

import com.example.demo.model.Skill;

public interface SkillService {

    Skill createSkill(Skill skill);

    Skill deactivateSkill(long id);
}
