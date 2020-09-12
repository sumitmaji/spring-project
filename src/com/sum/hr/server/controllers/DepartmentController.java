package com.sum.hr.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sum.hr.server.data.model.Department;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.response.ListData;
import com.sum.hr.server.response.Response;
import com.sum.hr.server.service.DepartmentService;
import com.sum.hr.shared.ModelColumn;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/data/department/getDepartment", method = RequestMethod.GET)
	public @ResponseBody
	Response<Department> getDepartment(Department department) throws HrException{
		try {

			Department dept =  departmentService
					.getDepartment(department.getId());
			if(dept != null){
				Response<Department> deptResponse = new Response<Department>();
				deptResponse.setSuccess(true);
				deptResponse.setT(dept);
				return deptResponse;
			}
			else{
				throw new HrException(ModelColumn.MESSAGE_NO_DATA);
			}
		} catch (HrException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/data/department/getDepartments", method = RequestMethod.GET)
	public @ResponseBody
	Response<ListData<Department>> getDepartments() throws HrException,Exception{
			
			ListData<Department> deListData = departmentService.getDepartments();
			Response<ListData<Department>> deptListResponse = new Response<ListData<Department>>();
			deptListResponse.setSuccess(true);
			deptListResponse.setT(deListData);
			return deptListResponse;
	}
}
