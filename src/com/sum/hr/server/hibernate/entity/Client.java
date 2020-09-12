package com.sum.hr.server.hibernate.entity;

import java.util.List;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Class<?>> classes = ClassFinder.find("com.sum.hr.server.hibernate.model");
		Template template;
		for(Class clazz : classes){
			template = new DAOTemplate(clazz);
		}
	}

}
