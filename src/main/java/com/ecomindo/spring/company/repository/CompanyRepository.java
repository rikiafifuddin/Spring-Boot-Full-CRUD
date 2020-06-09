package com.ecomindo.spring.company.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecomindo.spring.company.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	Optional<Company> findByName(String name);
}
