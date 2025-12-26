package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQuery;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final EmployeeSkillRepository esRepo;
    private final EmployeeRepository employeeRepo;
    private final SearchQueryRecordRepository searchQueryRepo;

    public SearchQueryServiceImpl(EmployeeSkillRepository esRepo,
                                  EmployeeRepository employeeRepo,
                                  SearchQueryRecordRepository searchQueryRepo) {
        this.esRepo = esRepo;
        this.employeeRepo = employeeRepo;
        this.searchQueryRepo = searchQueryRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skillNames, Long userId) {

        // 1️⃣ Save search query (optional but required by spec)
        SearchQuery query = new SearchQuery();
        query.setUserId(userId);
        query.setSkills(skillNames);
        searchQueryRepo.save(query);

        // 2️⃣ Get matching employee IDs
        List<Long> employeeIds =
                esRepo.findEmployeesByAllSkillNames(skillNames, skillNames.size());

        // 3️⃣ Fetch Employee entities
        return employeeRepo.findAllById(employeeIds);
    }
}
