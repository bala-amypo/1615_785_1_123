package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // getters and setters
}
