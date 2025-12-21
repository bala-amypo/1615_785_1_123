package com.example.demo.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.EmployeeSkill;
import java.util.*;


public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {


@Query("SELECT es.employee FROM EmployeeSkill es WHERE es.skill.name IN :skills AND es.active = true GROUP BY es.employee HAVING COUNT(DISTINCT es.skill.name) = :count")
List<Object> findEmployeesByAllSkillNames(@Param("skills") List<String> skills, @Param("count") long count);


List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);


List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);
}