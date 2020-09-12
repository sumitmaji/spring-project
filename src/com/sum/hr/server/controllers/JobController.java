package com.sum.hr.server.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sum.hr.server.data.model.Job;
import com.sum.hr.server.service.JobService;

@Controller
public class JobController {

	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/data/job/getJob", method = RequestMethod.GET)
	public @ResponseBody
	Job getJob(HttpServletRequest request) {
		try {
			
			return jobService.getJob(request.getParameter("name"));
		} catch (Exception e) {
			System.out.println("hi");
		}
		return null;
	}
}
