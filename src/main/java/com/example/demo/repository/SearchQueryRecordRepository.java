package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.SearchQueryRecord;
import java.util.List;


public interface SearchQueryRecordRepository extends JpaRepository<SearchQueryRecord, Long> {
List<SearchQueryRecord> findBySearcherId(Long searcherId);
}