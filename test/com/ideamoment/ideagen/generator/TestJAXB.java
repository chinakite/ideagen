/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.generator;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.ideamoment.ideagen.model.FileSystem;

/**
 * @author Chinakite Zhang
 *
 */
public class TestJAXB {
	@Test
	public void testJAXB() {
		try {
			JAXBContext context = JAXBContext.newInstance(FileSystem.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/filesystem/ideaweb.xml");
            FileSystem fs = (FileSystem)unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
