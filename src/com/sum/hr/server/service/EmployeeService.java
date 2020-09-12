package com.sum.hr.server.service;

import org.hibernate.HibernateException;

import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.hrexception.HrValidationException;
import com.sum.hr.server.response.ListData;



public interface EmployeeService {
	public ListData<Employee> getEmployees(String start, String limit) ;
	public Employee getEmployee(int id) ;
	public Employee updateEmployee(Employee employee) throws HibernateException, HrValidationException, HrException;
	
}
