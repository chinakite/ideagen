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
public class Integrate {
	private List<CopyTask> copies;
	private List<ExecuteTask> executes;
	private List<AddTask> adds;
	
	@XmlElement(name="copy")
	public List<CopyTask> getCopies() {
		return copies;
	}
	public void setCopies(List<CopyTask> copies) {
		this.copies = copies;
	}
	
	@XmlElement(name="execute")
	public List<ExecuteTask> getExecutes() {
		return executes;
	}
	public void setExecutes(List<ExecuteTask> executes) {
		this.executes = executes;
	}
	
	@XmlElement(name="add")
	public List<AddTask> getAdds() {
		return adds;
	}
	public void setAdds(List<AddTask> adds) {
		this.adds = adds;
	}
	
}
