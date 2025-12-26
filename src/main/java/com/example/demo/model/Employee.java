package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;   // 🔴 REQUIRED for JWT tests

    // ---------- GETTERS & SETTERS ----------

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {   // ✅ THIS FIXES THE ERROR
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
