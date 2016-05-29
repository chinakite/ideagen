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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ideamoment.ideagen.model.FileSystem;
import com.ideamoment.ideagen.model.FsDirectory;
import com.ideamoment.ideagen.model.FsFile;
import com.ideamoment.ideagen.util.CollectionUtils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Chinakite Zhang
 *
 */
public class FileSystemGenerator {
	/**
	 * 生成项目的源代码目录结构
	 * 
	 * @param projectFileSystemTemplate
	 */
	public void generateFileSystem(String projectFileSystemTemplate, String projectStoreDir, String projectName) {
	    try {
	    	JAXBContext context = JAXBContext.newInstance(FileSystem.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
            File templateFile = new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/filesystem/ideaweb.xml");
            FileSystem fs = (FileSystem)unmarshaller.unmarshal(templateFile);
            
            List<FsFile> files = fs.getFiles();
            String rootPath = projectStoreDir.replaceAll("\\\\", "/");
            if(!rootPath.endsWith("/")){
            	rootPath = rootPath + "/";
            }
            for(FsFile fsFile : files) {
            	String fileName = fsFile.getName();
            	if(fileName.startsWith("${") && fileName.endsWith("}")){
            		String val = fileName.substring(2, fileName.length() - 1);
            		if("projectName".equals(val)) {
            			fileName = projectName.toLowerCase();
            		}
            	}
            	File file = new File(rootPath + fileName);
            	if(!file.exists()){
            		file.createNewFile();
            	}
            	if(StringUtils.isNotBlank(fsFile.getTemplate())) {
            		Configuration cfg = new Configuration();
            		try {
            			cfg.setDirectoryForTemplateLoading(new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/ideaproject"));
            			cfg.setObjectWrapper(new DefaultObjectWrapper());
            			
            			// 创建根哈希表
            			Map root = new HashMap();
            			root.put("projectName", projectName);
            			
            			Template temp = cfg.getTemplate(fsFile.getTemplate());
            			
            			Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            			temp.process(root, out);
            			out.flush();
            		} catch (IOException e) {
            			e.printStackTrace();
            		} catch (TemplateException e) {
            			e.printStackTrace();
            		}
            	}
            }
            
            List<FsDirectory> directories = fs.getDirectories();
            genDirectories(directories, rootPath, projectName);
		} catch (JAXBException e) {
			e.printStackTrace();
			//TODO throw exception;
		} catch (IOException e) {
			//TODO throw exception;
			e.printStackTrace();
		}
	    
	}
	
	private void genDirectories(List<FsDirectory> directories, String parentPath, String projectName) {
		try{
			for(FsDirectory fsDir : directories) {
	        	String dirName = fsDir.getName();
	        	if(dirName.startsWith("${") && dirName.endsWith("}")){
            		String val = dirName.substring(2, dirName.length() - 1);
            		if("projectName".equals(val)) {
            			dirName = projectName.toLowerCase();
            		}
            	}
	        	
	        	String dirPath = parentPath;
	        	if(!dirPath.endsWith("/")){
	        		dirPath = dirPath + "/";
	        	}
	        	dirPath = dirPath + dirName;
	        	File file = new File(dirPath);
	        	if(!file.exists()) {
	        		file.mkdir();
	        	}
	        	
	        	List<FsFile> subFiles = fsDir.getFiles();
	        	for(FsFile subFsFile : subFiles) {
	        		String subFileName = subFsFile.getName();
	        		
	        		if(subFileName.startsWith("${") && subFileName.endsWith("}")){
	            		String val = subFileName.substring(2, subFileName.length() - 1);
	            		if("projectName".equals(val)) {
	            			subFileName = projectName.toLowerCase();
	            		}
	            	}
	        		
	            	File subfile = new File(dirPath + "/" + subFileName);
	            	if(!subfile.exists()){
	            		subfile.createNewFile();
	            	}
	            	
	            	if(StringUtils.isNotBlank(subFsFile.getTemplate())) {
	            		Configuration cfg = new Configuration();
	            		try {
	            			cfg.setDirectoryForTemplateLoading(new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/ideaproject"));
	            			cfg.setObjectWrapper(new DefaultObjectWrapper());
	            			
	            			// 创建根哈希表
	            			Map root = new HashMap();
	            			root.put("projectName", projectName);
	            			
	            			Template temp = cfg.getTemplate(subFsFile.getTemplate());
	            			
	            			Writer out = new OutputStreamWriter(new FileOutputStream(subfile), "UTF-8");
	            			temp.process(root, out);
	            			out.flush();
	            		} catch (IOException e) {
	            			e.printStackTrace();
	            		} catch (TemplateException e) {
	            			e.printStackTrace();
	            		}
	            	}
	        	}
	        	
	        	List<FsDirectory> subDirectories = fsDir.getSubDirectories();
	        	genDirectories(subDirectories, dirPath, projectName);
	        }
		}catch(IOException e) {
			//TODO throw new exception;
			e.printStackTrace();
		}
	}
}
