/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.component.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Chinakite Zhang
 *
 */
@XmlRootElement
public class Component {
	private String id;
	private String name;
	private String version;
	private Jars jars;
	private JavaCodes javaCodes;
	private PageCodes pageCodes;
	private Sqls sqls;
	private Configs configs;
	private Dependencies dependencies;
	private Integrate integrate;
	
	private Map<String, ComponentResource> cache;
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@XmlElement(name="javacodes")
	public JavaCodes getJavaCodes() {
		return javaCodes;
	}
	public void setJavaCodes(JavaCodes javaCodes) {
		this.javaCodes = javaCodes;
	}
	@XmlElement(name="jars")
	public Jars getJars() {
		return jars;
	}
	public void setJars(Jars jars) {
		this.jars = jars;
	}
	@XmlElement(name="pagecodes")
	public PageCodes getPageCodes() {
		return pageCodes;
	}
	public void setPageCodes(PageCodes pageCodes) {
		this.pageCodes = pageCodes;
	}
	@XmlElement(name="sqls")
	public Sqls getSqls() {
		return sqls;
	}
	public void setSqls(Sqls sqls) {
		this.sqls = sqls;
	}
	@XmlElement(name="configs")
	public Configs getConfigs() {
		return configs;
	}
	public void setConfigs(Configs configs) {
		this.configs = configs;
	}
	@XmlElement(name="dependencies")
	public Dependencies getDependencies() {
		return dependencies;
	}
	public void setDependencies(Dependencies dependencies) {
		this.dependencies = dependencies;
	}
	@XmlElement(name="integrate")
	public Integrate getIntegrate() {
		return integrate;
	}
	public void setIntegrate(Integrate integrate) {
		this.integrate = integrate;
	}
	
	public ComponentResource getElementById(String id) {
		if(cache == null) {
			cache = new HashMap<String, ComponentResource>();
		}
		
		if(cache.size() == 0) {
			List<ComponentFile> jarFiles = jars.getFiles();
			if(jarFiles != null) {
				for(ComponentFile jarFile : jarFiles) {
					cache.put(jarFile.getId(), jarFile);
				}
			}
			List<ComponentDirectory> jarDirs = jars.getDirectories();
			if(jarDirs != null) {
				for(ComponentDirectory jarDir : jarDirs) {
					cache.put(jarDir.getId(), jarDir);
				}
			}
			
			List<ComponentFile> javaCodeFiles = javaCodes.getFiles();
			if(javaCodeFiles != null) {
				for(ComponentFile javaCodeFile : javaCodeFiles) {
					cache.put(javaCodeFile.getId(), javaCodeFile);
				}
			}
			List<ComponentDirectory> javaCodeDirs = javaCodes.getDirectories();
			if(javaCodeDirs != null) {
				for(ComponentDirectory javaCodeDir : javaCodeDirs) {
					cache.put(javaCodeDir.getId(), javaCodeDir);
				}
			}
			
			List<ComponentFile> pageCodeFiles = pageCodes.getFiles();
			if(pageCodeFiles != null) {
				for(ComponentFile pageCodeFile : pageCodeFiles) {
					cache.put(pageCodeFile.getId(), pageCodeFile);
				}
			}
			List<ComponentDirectory> pageCodeDirs = pageCodes.getDirectories();
			if(pageCodeDirs != null) {
				for(ComponentDirectory pageCodeDir : pageCodeDirs) {
					cache.put(pageCodeDir.getId(), pageCodeDir);
				}
			}
			
			List<ComponentFile> sqlFiles = sqls.getFiles();
			if(sqlFiles != null) {
				for(ComponentFile sqlFile : sqlFiles) {
					cache.put(sqlFile.getId(), sqlFile);
				}
			}
			List<ComponentDirectory> sqlDirs = sqls.getDirectories();
			if(sqlDirs != null) {
				for(ComponentDirectory sqlDir : sqlDirs) {
					cache.put(sqlDir.getId(), sqlDir);
				}
			}
			
			List<ComponentFile> configFiles = configs.getFiles();
			if(configFiles != null) {
				for(ComponentFile configFile : configFiles) {
					cache.put(configFile.getId(), configFile);
				}
			}
			List<ComponentDirectory> configsDirs = configs.getDirectories();
			if(configsDirs != null) {
				for(ComponentDirectory configDir : configsDirs) {
					cache.put(configDir.getId(), configDir);
				}
			}
		}
		
		return cache.get(id);
	}
	
	public List<ComponentResource> getElementByTag(String tagName) {
		List result = new ArrayList();
		
		if("jars".equals(tagName.trim().toLowerCase())) {
			if(jars.getFiles() != null) {
				result = jars.getFiles();
			}
			if(jars.getDirectories() != null){
				result.addAll(jars.getDirectories());
			}
		}else if("javacodes".equals(tagName.trim().toLowerCase())) {
			if(javaCodes.getFiles() != null) {
				result = javaCodes.getFiles();
			}
			if(javaCodes.getDirectories() != null){
				result.addAll(javaCodes.getDirectories());
			}
		}else if("pagecodes".equals(tagName.trim().toLowerCase())) {
			if(pageCodes.getFiles() != null) {
				result = pageCodes.getFiles();
			}
			if(pageCodes.getDirectories() != null){
				result.addAll(pageCodes.getDirectories());
			}
		}else if("sqls".equals(tagName.trim().toLowerCase())) {
			if(sqls.getFiles() != null) {
				result = sqls.getFiles();
			}
			if(sqls.getDirectories() != null){
				result.addAll(sqls.getDirectories());
			}
		}else if("configs".equals(tagName.trim().toLowerCase())) {
			if(configs.getFiles() != null) {
				result = configs.getFiles();
			}
			if(configs.getDirectories() != null){
				result.addAll(configs.getDirectories());
			}
		}else{
			result = null;
		}
		
		return result;
	}
}
