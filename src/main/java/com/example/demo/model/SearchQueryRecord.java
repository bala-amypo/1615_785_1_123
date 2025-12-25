package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;

    private LocalDateTime searchedAt;

    public SearchQueryRecord() {
        this.searchedAt = LocalDateTime.now();
    }

    public SearchQueryRecord(String query) {
        this.query = query;
        this.searchedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public LocalDateTime getSearchedAt() {
        return searchedAt;
    }
}
