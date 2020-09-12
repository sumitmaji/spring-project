package ${package_name};

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sum.hr.server.hrexception.HrException;
<#list importList as import>
import ${import};
</#list>

@Repository
public class ${entityName}DAOImpl implements ${entityName}DAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static transient Logger log = Logger.getLogger(${entityName}DAOImpl.class); 
	public ${entityName} get(Long id) throws HrException{
		${entityName} ${entity_variable} = null;

		try {
			Criteria ${entity_variable}Crit = sessionFactory.getCurrentSession().createCriteria(${entityName}.class);
			${entity_variable}Crit.add(Restrictions.eq("id", id));
			${entity_variable} = (${entityName}) ${entity_variable}Crit.uniqueResult();
			return ${entity_variable};
		} catch (HibernateException ex) {
			throw new HrException("Could not get Country Data");
		}
	}
}
