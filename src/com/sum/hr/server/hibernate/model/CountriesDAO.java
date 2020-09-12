package com.sum.hr.server.hibernate.model;

import com.sum.hr.server.hibernate.model.Countries;
import com.sum.hr.server.hrexception.HrException;
import java.util.List;

public interface CountriesDAO{
	public Countries get(Long id) throws Exception;
}