package com.sum.hr.server.data.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sum.hr.server.data.model.Region;
import com.sum.hr.server.hrexception.HrException;

@Repository
public class RegionDAOImpl implements RegionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Region get(String regionName) throws HrException {
		Region region = null;
		try {
			Criteria regionCrit = sessionFactory.getCurrentSession().createCriteria(Region.class);
			regionCrit.add(Restrictions.eq("regionName", regionName));
			region = (Region) regionCrit.uniqueResult();
			return region;
		} catch (HibernateException ex) {
			throw new HrException("Counld not get Region");
		}
	}
}
