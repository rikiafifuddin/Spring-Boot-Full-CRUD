package com.ecomindo.spring.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CompanyDetail")
public class CompanyDetail {
	@Id
	private Long companyId;
	
	private String address;
	private String email;
	private String phone;
	private String postalCode;
	
	@OneToOne
	@JoinColumn(name="companyId", referencedColumnName = "id")
	Company company;
}
