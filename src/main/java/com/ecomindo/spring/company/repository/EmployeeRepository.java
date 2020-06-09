package com.ecomindo.spring.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomindo.spring.company.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query(value = "SELECT ProjectId FROM [Employeeproject] WHERE  EmployeeId=:id", nativeQuery = true)
	List<Long> findProjectId(@Param("id") Long id);
}
