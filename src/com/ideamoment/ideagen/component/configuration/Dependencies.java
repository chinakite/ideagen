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
public class Dependencies {
	private List<Depend> depends;

	@XmlElement(name="depend")
	public List<Depend> getDepends() {
		return depends;
	}

	public void setDepends(List<Depend> depends) {
		this.depends = depends;
	}
}
