package com.example.demo.model;


import com.example.demo.repository.EmployeeSkillRepository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeSkill {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private EmployeeSkillRepository employee;


@ManyToOne
private Skill skill;
private String proficiencyLevel;
private Integer yearsOfExperience;
private Boolean active = true;


}