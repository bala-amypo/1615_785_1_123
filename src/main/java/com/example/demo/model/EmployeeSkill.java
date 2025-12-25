package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data   // <-- THIS GENERATES GETTERS + SETTERS
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proficiencyLevel;

    private int yearsOfExperience;

    private Boolean active = true;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Skill skill;
}
