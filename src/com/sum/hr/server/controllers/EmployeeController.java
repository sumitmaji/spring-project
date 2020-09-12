package com.sum.hr.server.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.response.ListData;
import com.sum.hr.server.response.Message;
import com.sum.hr.server.response.Response;
import com.sum.hr.server.service.EmployeeService;
import com.sum.hr.shared.ModelColumn;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/data/employee/getEmployee", method = RequestMethod.GET)
	public @ResponseBody
	Response<Employee> getEmployee(Employee employee) throws HrException {

		Employee emp = employeeService.getEmployee(employee.getId());
		if (emp != null) {
			Response<Employee> employeeResponse = new Response<Employee>();
			employeeResponse.setSuccess(true);
			employeeResponse.setT(emp);
			return employeeResponse;
		} else {
			throw new HrException(ModelColumn.MESSAGE_NO_DATA);
		}
	}

	@RequestMapping(value = "/data/employee/getEmployees", method = RequestMethod.GET)
	public @ResponseBody
	Response<ListData<Employee>> getEmployees(HttpServletRequest request) {
		
		ListData<Employee> employees = employeeService.getEmployees(request.getParameter("start"),
				request.getParameter("limit"));
		
		Response<ListData<Employee>> employeeListResponse = new Response<ListData<Employee>>();
		employeeListResponse.setSuccess(true);
		employeeListResponse.setT(employees);
		
		return employeeListResponse;
		
	}

	@RequestMapping(value = "/data/employee/updEmployee", method = RequestMethod.GET)
	public @ResponseBody
	Response<Employee> updEmployee(
			@Valid @ModelAttribute(value = "employee") Employee employee,
			BindingResult result) throws Exception {
		Employee emp = employeeService.updateEmployee(employee);
		Response<Employee> employeeResponse = new Response<Employee>();
		Message message = new Message();
		message.setText(ModelColumn.MESSAGE_UPDATE_SUCCESS);
		employeeResponse.setMessage(message);
		employeeResponse.setSuccess(true);
		employeeResponse.setT(emp);
		return employeeResponse;
	}
}
