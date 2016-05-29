/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Chinakite Zhang
 *
 */
@XmlRootElement(name="fileSystem")
public class FileSystem {
	
	private List<FsDirectory> directories = new ArrayList<FsDirectory>();
	
	private List<FsFile> files = new ArrayList<FsFile>();
	
	@XmlElement(name="dir")
	public List<FsDirectory> getDirectories() {
		return directories;
	}

	public void setDirectories(List<FsDirectory> directories) {
		this.directories = directories;
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
		directories.add(directory);
	}
}
