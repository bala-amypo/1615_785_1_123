package com.example.demo.repository;

import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeId(Long employeeId);

    List<EmployeeSkill> findBySkillId(Long skillId);

    // 🔥 REQUIRED METHOD (FIXES YOUR ERROR)
    @Query("""
        SELECT es.employeeId
        FROM EmployeeSkill es
        JOIN Skill s ON es.skillId = s.id
        WHERE LOWER(s.name) IN :skillNames
          AND es.active = true
        GROUP BY es.employeeId
        HAVING COUNT(DISTINCT s.name) = :skillCount
    """)
    List<Long> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("skillCount") long skillCount
    );
}
