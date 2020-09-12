package com.sum.hr.server.aspects;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Freemark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			// 1. Configure FreeMarker
			//
			// You should do this ONLY ONCE, when your application starts,
			// then reuse the same Configuration object elsewhere.

			Configuration cfg = new Configuration();

			// Where do we load the templates from:
			cfg.setClassForTemplateLoading(Freemark.class, "template");

			// Some other recommended settings:
			cfg.setDefaultEncoding("UTF-8");
			cfg.setLocale(Locale.US);
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// 2.1. Prepare the template input:
			Map<String, Object> input = new HashMap<String, Object>();

			Set<String> importList = new HashSet<String>();
			importList.add("a.b.c");
			importList.add("a.c.g");
			input.put("importList", importList);

			Template template = cfg.getTemplate("DAO.ftl");

			// 2.3. Generate the output
			// Write output to the console
			Writer consoleWriter = new OutputStreamWriter(System.out);
			template.process(input, consoleWriter);

			// For the sake of example, also write output into a file:
			Writer fileWriter = new FileWriter(new File("output.html"));
			try {
				template.process(input, fileWriter);
			} finally {
				fileWriter.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("hi");
		}
	}

}
