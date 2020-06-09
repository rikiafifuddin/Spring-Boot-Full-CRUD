package com.ecomindo.spring.company.exception;

import org.springframework.context.ApplicationContextException;

public class CompanyNotFoundException extends ApplicationContextException{
	private static final long serialVersionUID = 1L;
	private Long id;
	
	public CompanyNotFoundException(Long id) {
		super ("Company ID ["+ id +"] Not Found");
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
