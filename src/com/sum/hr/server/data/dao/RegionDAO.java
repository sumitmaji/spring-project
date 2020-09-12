package com.sum.hr.server.data.dao;

import com.sum.hr.server.data.model.Region;
import com.sum.hr.server.hrexception.HrException;

public interface RegionDAO{
	public Region get(String regionName) throws HrException;
}
