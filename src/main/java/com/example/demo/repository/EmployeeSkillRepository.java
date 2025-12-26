package com.example.demo.repository;

import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeId(Long employeeId);

    List<EmployeeSkill> findBySkillId(Long skillId);

    @Query("""
        SELECT es.employee.id
        FROM EmployeeSkill es
        WHERE es.skill.name IN :skillNames
        GROUP BY es.employee.id
        HAVING COUNT(DISTINCT es.skill.name) = :skillCount
    """)
    List<Long> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("skillCount") long skillCount
    );
}
