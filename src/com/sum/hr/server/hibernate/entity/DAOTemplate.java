package com.sum.hr.server.hibernate.entity;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.sum.hr.server.aspects.Freemark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class DAOTemplate extends com.sum.hr.server.hibernate.entity.Template {
	private static final char DOT = '.';

	private static final char SLASH = '/';

	private static final String CLASS_SUFFIX = ".class";

	private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

	public DAOTemplate(Class clazz) {
		super(clazz);
	}

	void process() {
		try {
			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(DAOTemplate.class, "template");
			cfg.setDefaultEncoding("UTF-8");
			cfg.setLocale(Locale.US);
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			Map<String, Object> input = new HashMap<String, Object>();
			input.put("importList", getImportList());
			input.put("package_name", getPackageName());
			input.put("entityName", getEntityName());
			input.put("entity_variable", getEntity_variable());
			
			Template template = cfg.getTemplate("DAO.ftl");
			
			String scannedPath = getPackageName().replace(DOT, SLASH);
			URL scannedUrl = Thread.currentThread().getContextClassLoader()
					.getResource(scannedPath);
			if (scannedUrl == null) {
				throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR,
						scannedPath, getPackageName()));
			}
			
			String sourceDir = "E:\\Work\\JavaWorkSpace\\iHR4.0\\src";
			 
			String fileName = sourceDir + "\\"+getPackageName().replace(DOT, '\\')+ "\\"+getEntityName()+"DAO.java";
			
			Writer fileWriter = new FileWriter(new File(fileName));
			try {
				template.process(input, fileWriter);
			}catch(Exception e){
				System.out.println(e);
			}
			finally {
				fileWriter.close();
			}
			
			
			template = cfg.getTemplate("DAOImpl.ftl");
			
			scannedPath = getPackageName().replace(DOT, SLASH);
			scannedUrl = Thread.currentThread().getContextClassLoader()
					.getResource(scannedPath);
			if (scannedUrl == null) {
				throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR,
						scannedPath, getPackageName()));
			}
			
			 
			fileName = sourceDir + "\\"+getPackageName().replace(DOT, '\\')+ "\\"+getEntityName()+"DAOImpl.java";
			
			fileWriter = new FileWriter(new File(fileName));
			try {
				template.process(input, fileWriter);
			}catch(Exception e){
				System.out.println(e);
			}
			finally {
				fileWriter.close();
			}


			
			template = cfg.getTemplate("Service.ftl");
			
			scannedPath = getPackageName().replace(DOT, SLASH);
			scannedUrl = Thread.currentThread().getContextClassLoader()
					.getResource(scannedPath);
			if (scannedUrl == null) {
				throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR,
						scannedPath, getPackageName()));
			}
			
			 
			fileName = sourceDir + "\\"+getPackageName().replace(DOT, '\\')+ "\\"+getEntityName()+"Service.java";
			
			fileWriter = new FileWriter(new File(fileName));
			try {
				template.process(input, fileWriter);
			}catch(Exception e){
				System.out.println(e);
			}
			finally {
				fileWriter.close();
			}

			template = cfg.getTemplate("ServiceImpl.ftl");
			
			scannedPath = getPackageName().replace(DOT, SLASH);
			scannedUrl = Thread.currentThread().getContextClassLoader()
					.getResource(scannedPath);
			if (scannedUrl == null) {
				throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR,
						scannedPath, getPackageName()));
			}
			
			 
			fileName = sourceDir + "\\"+getPackageName().replace(DOT, '\\')+ "\\"+getEntityName()+"ServiceImpl.java";
			
			fileWriter = new FileWriter(new File(fileName));
			try {
				template.process(input, fileWriter);
			}catch(Exception e){
				System.out.println(e);
			}
			finally {
				fileWriter.close();
			}
			
		} catch (Exception e) {
			System.out.println(e+"");
		}
	}

}
