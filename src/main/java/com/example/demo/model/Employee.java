package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private boolean active = true;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeSkill> skills;

    // getters and setters
}
