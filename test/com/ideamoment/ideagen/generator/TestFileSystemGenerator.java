/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.generator;

import org.junit.Test;

/**
 * @author Chinakite Zhang
 *
 */
public class TestFileSystemGenerator {
	@Test
	public void testGenetateFileSystem() {
		FileSystemGenerator fsg = new FileSystemGenerator();
		fsg.generateFileSystem(
				"E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/filesystem/ideaweb.xml", 
				"E:/testideagen", 
				"testideagen");
	}
}
