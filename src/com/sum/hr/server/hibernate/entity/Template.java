package com.sum.hr.server.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class Template {

	private Set<String> importList = new HashSet<String>();
	private String entityName;
	private String keyField;
	private String packageName;
	private String entity_variable;
	private Class clazz;
	
	
	public Template(Class clazz) {
		super();
		this.clazz = clazz;
		populateProperties();
		process();
	}

	void process(){
	}
	
	void populateProperties(){
		this.entityName = clazz.getSimpleName();
		this.packageName = clazz.getPackage().getName();
		importList.add(clazz.getName());
		this.entity_variable = entityName.toLowerCase(); 
	}
	
	public Set<String> getImportList() {
		return importList;
	}
	public String getEntityName() {
		return entityName;
	}
	public String getKeyField() {
		return keyField;
	}
	public String getPackageName() {
		return packageName;
	}

	public String getEntity_variable() {
		return entity_variable;
	}
}
