package com.example.demo.service.impl;

import com.example.demo.model.SearchQuery;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRepository searchQueryRepository;
    private final EmployeeSkillRepository employeeSkillRepository;

    public SearchQueryServiceImpl(SearchQueryRepository searchQueryRepository,
                                  EmployeeSkillRepository employeeSkillRepository) {
        this.searchQueryRepository = searchQueryRepository;
        this.employeeSkillRepository = employeeSkillRepository;
    }

    @Override
    public List<Long> searchEmployeesBySkills(List<String> skills) {

        // save search history
        SearchQuery query = new SearchQuery();
        query.setSkills(skills);
        searchQueryRepository.save(query);

        // fetch employee IDs
        return employeeSkillRepository.findEmployeeIdsBySkillNames(skills, skills.size());
    }
}
