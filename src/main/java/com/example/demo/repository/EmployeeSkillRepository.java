package com.example.demo.repository;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);

    @Query("""
      SELECT es.employee FROM EmployeeSkill es
      WHERE LOWER(es.skill.name) IN :skills
      GROUP BY es.employee
      HAVING COUNT(DISTINCT es.skill.name) = :count
    """)
    List<Employee> findEmployeesByAllSkillNames(List<String> skills, long count);
}
