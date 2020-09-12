package com.sum.hr.server.data.dao;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.hrexception.HrValidationException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DAO dao;
	
	public Employee get(Integer id) throws HrException {
		try {
			Employee emp = null;
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Employee.class);
			crit.add(Restrictions.eq("id", id));
			emp = (Employee) crit.uniqueResult();
			return emp;
		} catch (HibernateException ex) {
			throw new HrException("Employee not found");
		}
	}

	public void create(Employee emp) throws HrException {
		try {
			sessionFactory.getCurrentSession().save(emp);
		} catch (HibernateException ex) {
			throw new HrException("Error in creating EMployee");
		}
	}

	public void delete(Employee emp) throws HrException {
		try {
			sessionFactory.getCurrentSession().delete(emp);
		} catch (HibernateException ex) {
			throw new HrException("Error in deleting Employee");
		}
	}

	public void update(Employee employee) throws HibernateException, HrValidationException, HrException {
			Employee emp = get(employee.getId());
			emp.setFirstName(employee.getFirstName());
			dao.update(emp);
	}

	public List<Employee> list(String start, String limit) throws HrException {
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Employee.class);
			if (start != null) {
				crit.setFirstResult(Integer.parseInt(start));
			}
			if (limit != null) {
				crit.setMaxResults(Integer.parseInt(limit));
			}

			@SuppressWarnings("unchecked")
			List<Employee> list = crit.list();
			return list;
		} catch (HibernateException ex) {
			throw new HrException("Data no fetched");
		}
	}

	public Integer getEmployeeCount() throws HrException {
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Employee.class);
			crit.setProjection(Projections.rowCount());
			return (Integer) crit.uniqueResult();

		} catch (HibernateException e) {
			throw new HrException(e.getMessage());
		}
	}
}
