package com.sum.hr.server.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sum.hr.server.data.model.Location;
import com.sum.hr.server.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/data/location/getLocation", method = RequestMethod.GET)
	public @ResponseBody
	Location getLocation(HttpServletRequest request) {
		try {
			
			return locationService.getLocation(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			System.out.println("hi");
		}
		return null;
	}
}
