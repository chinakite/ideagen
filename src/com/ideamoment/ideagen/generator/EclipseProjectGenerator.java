/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Chinakite Zhang
 *
 */
public class EclipseProjectGenerator {
	
	/**
	 * 生成.project文件
	 * 
	 * @param projectName 项目名称
	 */
	public void generateDotProjectFile(String projectName, String storeDir) {
		Configuration cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/eclipseproject"));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			
			// 创建根哈希表
			Map root = new HashMap();
			root.put("projectName", projectName);
			
			Template temp = cfg.getTemplate("dotproject.ftl");
			
			Writer out = new OutputStreamWriter(new FileOutputStream(new File(storeDir + File.separator + ".project")), "UTF-8");
			temp.process(root, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成.project文件
	 * 
	 * @param projectName 项目名称
	 */
	public void generateDotClasspathFile(String storeDir) {
		Configuration cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/eclipseproject"));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			
			// 创建根哈希表
			Map root = new HashMap();
			
			Template temp = cfg.getTemplate("dotclasspath.ftl");
			
			Writer out = new OutputStreamWriter(new FileOutputStream(new File(storeDir + File.separator + ".classpath")), "UTF-8");
			temp.process(root, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
