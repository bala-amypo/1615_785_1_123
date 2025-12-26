package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository repo;
    private final EmployeeSkillRepository esRepo;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repo,
                                  EmployeeSkillRepository esRepo) {
        this.repo = repo;
        this.esRepo = esRepo;
    }

    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {
        if (skills == null || skills.isEmpty())
            throw new IllegalArgumentException("must not be empty");

        List<String> normalized = skills.stream()
                .map(s -> s.trim().toLowerCase())
                .distinct()
                .toList();

        List<Employee> result =
                esRepo.findEmployeesByAllSkillNames(normalized, normalized.size());

        SearchQueryRecord r = new SearchQueryRecord();
        r.setSearcherId(searcherId);
        r.setSkillsRequested(String.join(",", normalized));
        r.setResultsCount(result.size());
        repo.save(r);

        return result;
    }

    public SearchQueryRecord getQueryById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<SearchQueryRecord> getQueriesForUser(Long id) {
        return repo.findBySearcherId(id);
    }

    public void saveQuery(SearchQueryRecord r) {
        repo.save(r);
    }
}
