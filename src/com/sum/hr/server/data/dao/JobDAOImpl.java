package com.sum.hr.server.data.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sum.hr.server.data.model.Job;
import com.sum.hr.server.hrexception.HrException;

@Repository
public class JobDAOImpl implements JobDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Job get(String name) throws HrException{
		try{
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Job.class);
			crit.add(Restrictions.eq("jobTitle", name));
			Job job = (Job)crit.uniqueResult();
			return job;
		}catch(HibernateException ex){
			throw new HrException("Job details not fetched");
		}
	}

}
