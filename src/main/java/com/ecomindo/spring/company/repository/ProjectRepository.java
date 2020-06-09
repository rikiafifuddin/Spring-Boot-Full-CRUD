package com.ecomindo.spring.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomindo.spring.company.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Query(value = "SELECT EmployeeId FROM [Employeeproject] WHERE  ProjectId=:id", nativeQuery = true)
	List<Long> findEmployeeId(@Param("id") Long id);
}
