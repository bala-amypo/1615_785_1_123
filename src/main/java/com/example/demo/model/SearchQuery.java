package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "search_queries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Skills used in search
    @ElementCollection
    @CollectionTable(
            name = "search_query_skills",
            joinColumns = @JoinColumn(name = "search_query_id")
    )
    @Column(name = "skill_name")
    private List<String> skills;

    // Minimum experience filter
    private long minExperience;

    // Timestamp of search
    private LocalDateTime searchedAt;
}
