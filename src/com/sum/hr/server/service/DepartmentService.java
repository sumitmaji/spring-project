package com.sum.hr.server.service;

import com.sum.hr.server.data.model.Department;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.response.ListData;



public interface DepartmentService {
	public Department getDepartment(int i) throws HrException;
	public ListData<Department> getDepartments() throws HrException, Exception;
	
}
