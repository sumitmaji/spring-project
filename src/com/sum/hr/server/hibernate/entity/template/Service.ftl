package ${package_name};

<#list importList as import>
import ${import};
</#list>

public interface ${entityName}Service {
	public ${entityName} get${entityName}(Long id) throws Exception;
}
