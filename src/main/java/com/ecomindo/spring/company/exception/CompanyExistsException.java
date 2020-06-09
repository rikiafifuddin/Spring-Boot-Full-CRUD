package com.ecomindo.spring.company.exception;

import org.springframework.context.ApplicationContextException;

public class CompanyExistsException extends ApplicationContextException{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public CompanyExistsException(String name) {
		super ("Company Name ["+ name +"] is exists");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
