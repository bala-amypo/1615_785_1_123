package com.example.demo.repository;

import com.example.demo.model.SearchQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchQueryRecordRepository extends JpaRepository<SearchQuery, Long> {
}
