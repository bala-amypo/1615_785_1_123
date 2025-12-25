package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data   // generates getters & setters automatically
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String department;

    private String jobTitle;

    private boolean active = true;
}
