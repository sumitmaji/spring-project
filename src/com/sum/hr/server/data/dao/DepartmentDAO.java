package com.sum.hr.server.data.dao;

import java.util.List;

import com.sum.hr.server.data.model.Department;
import com.sum.hr.server.hrexception.HrException;

public interface DepartmentDAO{
	public Department get(int id) throws HrException;
	public List<Department> list() throws HrException;
	

}
