package com.sum.hr.server.data.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.hrexception.HrValidationException;

public interface EmployeeDAO {

	public Employee get(Integer id) throws HrException;

	public void create(Employee emp) throws HrException;

	public void delete(Employee emp) throws HrException;

	public void update(Employee employee) throws HibernateException, HrValidationException, HrException;

	public List<Employee> list(String start, String limit) throws HrException;

	public Integer getEmployeeCount() throws HrException;
}
