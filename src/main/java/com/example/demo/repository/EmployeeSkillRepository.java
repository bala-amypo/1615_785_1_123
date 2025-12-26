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
    SELECT es.employee.id
    FROM EmployeeSkill es
    WHERE es.skill.name IN :skills
    GROUP BY es.employee.id
    HAVING COUNT(DISTINCT es.skill.name) = :skillCount
"")
List<Long> findEmployeeIdsBySkillNames(
        @Param("skills") List<String> skills,
        @Param("skillCount") long skillCount
);

}
