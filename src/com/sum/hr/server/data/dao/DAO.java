package com.sum.hr.server.data.dao;

import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

	private static final Logger log = Logger.getAnonymousLogger();
	
	@Autowired 
	private SessionFactory sessionFactory;

	protected DAO() {
	}

	public void save(Object obj) throws HibernateException{
		sessionFactory.getCurrentSession().save(obj);
	}
	
	public void update(Object obj) throws HibernateException{
		sessionFactory.getCurrentSession().update(obj);
	}
	
}
