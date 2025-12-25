package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SearchQueryRecord;

public interface SearchQueryService {

    SearchQueryRecord saveQuery(String query);

    List<SearchQueryRecord> getAllQueries();
}
