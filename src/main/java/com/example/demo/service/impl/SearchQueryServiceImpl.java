package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository repository;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public SearchQueryRecord saveQuery(String query) {
        SearchQueryRecord record = new SearchQueryRecord(query);
        return repository.save(record);
    }

    @Override
    public List<SearchQueryRecord> getAllQueries() {
        return repository.findAll();
    }
}
