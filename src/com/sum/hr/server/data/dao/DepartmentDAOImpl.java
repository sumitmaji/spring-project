package com.sum.hr.server.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sum.hr.server.data.model.Department;
import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Department get(int id) throws HrException{
		try{
			Department department = (Department) sessionFactory.getCurrentSession().get(Department.class, id);
			return department;
		}catch(HibernateException ex){
			ex.printStackTrace();
			throw new HrException(ex.getMessage());
		}
	}

	@Override
	public List<Department> list() throws HrException {
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Department.class);
			List<Department> list = crit.list();
			return list;
		} catch (HibernateException ex) {
			throw new HrException("Data not fetched"+ex,ex);
		}
	}

}
