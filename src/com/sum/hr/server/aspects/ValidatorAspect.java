package com.sum.hr.server.aspects;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrValidationException;

@Component
@Aspect
public class ValidatorAspect {

	@Autowired
	private Validator validator;

	@Pointcut("execution(* com.sum.hr.server.data.dao.DAO.update*(..)) && args(employee,..))")
	private void validateupd(Employee employee){}

	
	@Before("validateupd(employee)")
	public void validateBeforeUpdate(Employee employee) throws HrValidationException{
		validateEmployee(employee);
	}
	
	private void validateEmployee(Employee employee) throws HrValidationException{
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate((Object)employee);
		if(constraintViolations != null && constraintViolations.size() > 0)
			throw new HrValidationException(constraintViolations);
	}
}
