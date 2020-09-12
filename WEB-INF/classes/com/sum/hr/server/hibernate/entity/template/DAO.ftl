package ${package_name};

<#list importList as import>
import ${import};
</#list>
import com.sum.hr.server.hrexception.HrException;
import java.util.List;

public interface ${entityName}DAO{
	public ${entityName} get(Long id) throws Exception;
}