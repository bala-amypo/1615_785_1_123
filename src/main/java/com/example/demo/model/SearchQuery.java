package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "search_queries")
public class SearchQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ElementCollection
    @CollectionTable(
            name = "search_query_skills",
            joinColumns = @JoinColumn(name = "search_query_id")
    )
    @Column(name = "skill_name")
    private List<String> skills;

    // getters and setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
