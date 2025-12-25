package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE es.skill.skillName IN :skillNames
          AND es.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.skillName) = :count
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("count") long count
    );

    // ✅ ADD THIS
    List<EmployeeSkill> findByEmployee_Id(Long employeeId);
}
