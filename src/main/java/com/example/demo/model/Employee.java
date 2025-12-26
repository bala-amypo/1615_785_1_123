package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;   // 🔴 REQUIRED

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;

    private Boolean active = true;  // 🔴 REQUIRED

    // ---------- GETTERS & SETTERS ----------

    public Long getId() {
        return id;
    }

    public String getFullName() {   // ✅ FIX #1
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {   // ✅ FIX #2
        return active;
    }

    public void setActive(Boolean active) {  // ✅ FIX #3
        this.active = active;
    }
}
