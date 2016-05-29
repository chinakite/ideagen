/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Chinakite Zhang
 *
 */
public class FsDirectory {
	private String name;

	private List<FsDirectory> subDirectories = new ArrayList<FsDirectory>();
	
	private List<FsFile> files = new ArrayList<FsFile>();
	
	@XmlElement(name="dir")
	public List<FsDirectory> getSubDirectories() {
		return subDirectories;
	}

	public void setSubDirectories(List<FsDirectory> directories) {
		this.subDirectories = directories;
	}

	@XmlElement(name="file")
	public List<FsFile> getFiles() {
		return files;
	}

	public void setFiles(List<FsFile> files) {
		this.files = files;
	}
	
	public void addFile(FsFile file) {
		files.add(file);
	}
	
	public void addDirectory(FsDirectory directory) {
		subDirectories.add(directory);
	}
	
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
