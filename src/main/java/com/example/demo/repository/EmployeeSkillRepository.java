package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    // ✅ FIX for EmployeeSkillServiceImpl
    List<EmployeeSkill> findByEmployee_Id(Long employeeId);

    // ✅ FIX for SearchQueryServiceImpl
    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE es.skill.skillName IN :skillNames
          AND es.employee.id <> :searcherId
          AND es.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.skillName) = :skillCount
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("searcherId") Long searcherId,
            @Param("skillCount") long skillCount
    );
}
