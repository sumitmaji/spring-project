package com.sum.hr.server.hrexception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.sum.hr.server.data.model.Employee;

public class HrValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202206903538794942L;

	private Set<ConstraintViolation<Object>> constraintViolations;

	public HrValidationException(
			Set<ConstraintViolation<Object>> constraintViolations) {
		super();
		this.constraintViolations = constraintViolations;
	}

	public Set<ConstraintViolation<Object>> getConstraintViolations() {
		return constraintViolations;
	}

	public void setConstraintViolations(
			Set<ConstraintViolation<Object>> constraintViolations) {
		this.constraintViolations = constraintViolations;
	}
}
