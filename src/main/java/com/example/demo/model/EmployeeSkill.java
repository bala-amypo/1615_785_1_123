package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Skill skill;

    private int proficiency;

    private boolean active;

    // ✅ REQUIRED GETTERS & SETTERS

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
