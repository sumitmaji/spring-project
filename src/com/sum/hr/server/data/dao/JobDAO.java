package com.sum.hr.server.data.dao;

import com.sum.hr.server.data.model.Job;
import com.sum.hr.server.hrexception.HrException;

public interface JobDAO{
	public Job get(String name) throws HrException;

}
