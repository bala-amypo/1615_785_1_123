package com.example.demo.repository;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long id);
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long id);

    @Query("SELECT es.employee FROM EmployeeSkill es " +
           "WHERE LOWER(es.skill.name) IN :skills " +
           "GROUP BY es.employee HAVING COUNT(DISTINCT es.skill.name) = :count")
    List<Employee> findEmployeesByAllSkillNames(List<String> skills, Long count);
}
