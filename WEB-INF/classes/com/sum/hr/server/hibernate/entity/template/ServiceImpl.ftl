package ${package_name};

<#list importList as import>
import ${import};
</#list>

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${package_name}.${entityName}DAO;
import com.sum.hr.server.hrexception.HrException;


@Service("${entity_variable}Service")  
public class ${entityName}ServiceImpl implements ${entityName}Service {

	private static transient Logger log = Logger
			.getLogger(${entityName}ServiceImpl.class);
	@Autowired
	private ${entityName}DAO ${entity_variable}DAO;

	@Transactional
	public ${entityName} get${entityName}(Long id) throws Exception {
		try {

			${entityName} ${entity_variable} = ${entity_variable}DAO.get(id);
			return ${entity_variable};

		} catch (HrException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

