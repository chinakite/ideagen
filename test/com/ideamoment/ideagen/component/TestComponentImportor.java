/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.component;

import org.junit.Test;

/**
 * @author Chinakite Zhang
 *
 */
public class TestComponentImportor {
	@Test
	public void testImportComponent(){
		ComponentImportor importor = new ComponentImportor();
		importor.setRepositoryPath("E:\\repository");
		importor.importComponent("ideadp", "0.1", "E:\\testideagen");
	}
}
