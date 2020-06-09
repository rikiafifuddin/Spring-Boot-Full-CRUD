package com.ecomindo.spring.company.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToOne(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval=true)
	private CompanyDetail companyDetail;
	
	@OneToMany(mappedBy = "company",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Employee> employee;
}
