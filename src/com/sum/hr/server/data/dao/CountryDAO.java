package com.sum.hr.server.data.dao;

import com.sum.hr.server.data.model.Country;
import com.sum.hr.server.data.model.Region;
import com.sum.hr.server.hrexception.HrException;

public interface CountryDAO{
	public Country get(String name) throws HrException;
	
	public void create(String id,String countryName, Region region) throws HrException;
	
	public void delete(Country country) throws HrException;
	
	public void update(Country county) throws HrException;
}
