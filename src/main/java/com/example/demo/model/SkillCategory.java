package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryName;

    private Boolean active = true;

    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setActive(Boolean active) { this.active = active; }
}
