package com.sum.hr.server.data.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sum.hr.server.data.model.Location;
import com.sum.hr.server.hrexception.HrException;

@Repository
public class LocationDAOImpl implements LocationDAO{
	private static transient Logger log = Logger.getLogger(LocationDAOImpl.class); 
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Location get(int id) throws HrException{
		Location location = null;

		try {
			Criteria countryCrit = sessionFactory.getCurrentSession().createCriteria(Location.class);
			countryCrit.add(Restrictions.eq("id", id));
			location = (Location) countryCrit.uniqueResult();
			return location;
		} catch (HibernateException ex) {
			throw new HrException("Could not get Location Data");
		}
	}
}
