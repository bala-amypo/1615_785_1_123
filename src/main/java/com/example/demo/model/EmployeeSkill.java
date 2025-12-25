package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;   // ✅ ENTITY ONLY

    private boolean active = true;

    // getters and setters
}
