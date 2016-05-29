/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.component.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Chinakite Zhang
 *
 */
public class Sqls {
	
	private List<ComponentFile> files;
	private List<ComponentDirectory> directories;
	
	@XmlElement(name="file")
	public List<ComponentFile> getFiles() {
		return files;
	}
	public void setFiles(List<ComponentFile> files) {
		this.files = files;
	}
	
	@XmlElement(name="dir")
	public List<ComponentDirectory> getDirectories() {
		return directories;
	}
	public void setDirectories(List<ComponentDirectory> directories) {
		this.directories = directories;
	}
}
