package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployee_Id(Long employeeId);

    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE es.skill.skillName IN :skillNames
          AND es.employee.id <> :searcherId
          AND es.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.skillName) = :count
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("searcherId") Long searcherId,
            @Param("count") long count
    );
}
