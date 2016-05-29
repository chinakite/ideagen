/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.component.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Chinakite Zhang
 *
 */
public class CopyTask {
	private String to;
	
	private List<TagRef> tagRefs;
	private List<IdRef> idRefs;

	@XmlAttribute
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@XmlElement(name="tag-ref")
	public List<TagRef> getTagRefs() {
		return tagRefs;
	}

	public void setTagRefs(List<TagRef> tagRefs) {
		this.tagRefs = tagRefs;
	}

	@XmlElement(name="id-ref")
	public List<IdRef> getIdRefs() {
		return idRefs;
	}

	public void setIdRefs(List<IdRef> idRefs) {
		this.idRefs = idRefs;
	}

}
