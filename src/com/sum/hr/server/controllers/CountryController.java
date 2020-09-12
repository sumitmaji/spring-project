package com.sum.hr.server.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sum.hr.server.data.model.Country;
import com.sum.hr.server.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/data/country/getCountry", method = RequestMethod.GET)
	public @ResponseBody
	Country getCountry(HttpServletRequest request) {
		try {
			
			return countryService.getCountry(request.getParameter("name"));
		} catch (Exception e) {
			System.out.println("hi");
		}
		return null;
	}
}
