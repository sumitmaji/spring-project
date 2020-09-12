package com.sum.hr.shared;

public interface ModelColumn {
	//columns name
	public String EMPLOYEE_FIRST_NAME = "firstName";
	public String EMPLOYEE_ID = "id";
	public String EMPLOYEE_LAST_NAME="lastName";
	public String EMPLOYEE_HIRE_DATE = "hireDate";
	public String EMPLOYEE_JOB_TITLE = "jobTitle";
	public String EMPLOYEE_DEPARTMENT_NAME = "deptName";
	public String EMPLOYEE_DEPARTMENT_ID = "deptId";
	
	
	//column mapping
	public String MAP_EMPLOYEE_FIRST_NAME = "firstName";
	public String MAP_EMPLOYEE_ID = "id";
	public String MAP_EMPLOYEE_LAST_NAME="lastName";
	public String MAP_EMPLOYEE_HIRE_DATE = "hireDate";
	public String MAP_EMPLOYEE_JOB_TITLE = "job/jobTitle";
	public String MAP_EMPLOYEE_DEPARTMENT_NAME = "deptId/deptName";
	public String MAP_EMPLOYEE_DEPARTMENT_ID = "deptId/id";
	
	
	
	//Status
	public String MESSAGE_UPDATE_SUCCESS = "Record updated successfully.";
	public String MESSAGE_SAVE = "Saving data...";
	public String MESSAGE_LOAD = "Loading...";
	public String MESSAGE_INFO = "Info";
	public String MESSAGE_NO_DATA = "No Record Found.";
	
	
	
	//HEAD ROW
	public String EMPLOYEE_XML_READER = "employee";
	public String COUNT_XML_READER = "count";
	
	
}
