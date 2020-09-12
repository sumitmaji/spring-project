package com.sum.hr.server.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model,
			@RequestParam(value = "invalid", required = false) String invalid) {

		if (invalid != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		return "login";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("msg", "Sorry " + username
				+ " You don't have privileges to view this page!!!");
		return "403";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployee(ModelMap model) {
		model.addAttribute("id", 1);
		model.addAttribute("name", "Pankaj");
		return "employee";
	}

}
