package com.ecomindo.spring.company.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private BigDecimal salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="companyId", nullable=false)
	private Company company;
	
	@ManyToMany
	@JoinTable(name = "employeeproject",
	joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "projectId", referencedColumnName = "id"))
	private List<Project> projects;
}
