package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private String skillName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;   // ✅ MUST BE ENTITY

    @SuppressWarnings("unused")
    private boolean active = true;

    // getters & setters
}
