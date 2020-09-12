package com.sum.hr.server.data.dao;

import com.sum.hr.server.data.model.Location;
import com.sum.hr.server.hrexception.HrException;

public interface LocationDAO{
	public Location get(int id) throws HrException;
}
