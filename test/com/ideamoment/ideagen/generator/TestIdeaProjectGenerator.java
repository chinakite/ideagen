/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.generator;

import org.junit.Test;

import com.ideamoment.ideagen.component.configuration.Component;
import com.ideamoment.ideagen.model.ProjectDeployInfo;
import com.ideamoment.ideagen.model.ProjectInfo;

/**
 * @author Chinakite Zhang
 *
 */
public class TestIdeaProjectGenerator {
	@Test
	public void testGenerateIdeaProject() {
		String projectPath = "E:\\testideagen";
		IdeaProjectGenerator gen = new IdeaProjectGenerator();
		gen.generateIdeaProject(projectPath);
	}
	
	@Test
    public void testGenerateIdeaProjectByProjectInfo() {
	    ProjectInfo proInfo = new ProjectInfo();
	    proInfo.setProjectName("ttdemo");
	    proInfo.setProjectPath("D://ttdemo");
	    
	    ProjectDeployInfo deployInfo = new ProjectDeployInfo();
	    deployInfo.setServerRootPath("D:/Developer/Server/apache-tomcat-6.0.36");
	    proInfo.setDeployInfo(deployInfo);
	    
	    Component ideadpComp = new Component();
	    ideadpComp.setId("ideadp");
	    ideadpComp.setVersion("0.1");
	    proInfo.addComponent(ideadpComp);
	    
//	    Component ideajdbcComp = new Component();
//	    ideajdbcComp.setId("ideajdbc");
//	    ideajdbcComp.setVersion("0.1");
//        proInfo.addComponent(ideajdbcComp);
	    
        IdeaProjectGenerator gen = new IdeaProjectGenerator();
        gen.generateIdeaProject(proInfo);
    }
}
