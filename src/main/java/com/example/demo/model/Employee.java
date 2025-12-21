package com.example.demo.model;

import jakarta.persistence.*;
import lombok.
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String department;

    private String jobTitle;

    private boolean active = true;

}