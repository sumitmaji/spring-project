package com.sum.hr.server.data.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sum.hr.server.data.model.Country;
import com.sum.hr.server.data.model.Region;
import com.sum.hr.server.hrexception.HrException;

@Repository
public class CountryDAOImpl implements CountryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static transient Logger log = Logger.getLogger(CountryDAOImpl.class); 
	public Country get(String name) throws HrException{
		Country country = null;

		try {
			Criteria countryCrit = sessionFactory.getCurrentSession().createCriteria(Country.class);
			countryCrit.add(Restrictions.eq("countryName", name));
			country = (Country) countryCrit.uniqueResult();
			return country;
		} catch (HibernateException ex) {
			throw new HrException("Could not get Country Data");
		}
	}
	
	public void create(String id,String countryName, Region region) throws HrException{
		Country country = null;
		try{
			country = new Country(id, countryName, region);
			sessionFactory.getCurrentSession().save(country);
			log.info("Country object created successfully");
		}catch(HibernateException ex){
			throw new HrException("Could not create new Country");
		}
	}
	
	public void delete(Country country) throws HrException{
		try{
			sessionFactory.getCurrentSession().delete(country);
			log.info("Country deleted successfully");
		}catch(HibernateException ex){
			throw new HrException("Could not delete Country");
		}
	}
	
	public void update(Country county) throws HrException{
		try{
			sessionFactory.getCurrentSession().update(county);
			log.info("Country updated successfully");
		}catch(HibernateException ex){
			throw new HrException("Count not update country");
		}
	}
}
