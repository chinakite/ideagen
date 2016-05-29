/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.generator;

import java.util.List;

import com.ideamoment.ideagen.component.ComponentImportor;
import com.ideamoment.ideagen.component.configuration.Component;
import com.ideamoment.ideagen.model.ProjectInfo;

/**
 * @author Chinakite Zhang
 *
 */
public class IdeaProjectGenerator {

    public void generateIdeaProject(ProjectInfo projectInfo) {
        //生成文件目录和基本配置文件
        FileSystemGenerator fsg = new FileSystemGenerator();
        fsg.generateFileSystem(
                "E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/filesystem/ideaweb.xml", 
                projectInfo.getProjectPath(), 
                projectInfo.getProjectName());
        
        
        EclipseProjectGenerator gen = new EclipseProjectGenerator();
        //生成.project文件
        gen.generateDotProjectFile(projectInfo.getProjectName(), projectInfo.getProjectPath());
        
        //生成.classpath文件
        gen.generateDotClasspathFile(projectInfo.getProjectPath());
    
        //生成Tomcat部署文件
        TomcatContextFileGenerator tomcatGen = new TomcatContextFileGenerator();
        tomcatGen.generateTomcatContextFile(projectInfo);
        
        //导入module
        List<Component> components = projectInfo.getComponents();
        ComponentImportor compImportor = new ComponentImportor();
        compImportor.setRepositoryPath("F:/idearepos/components");
        for(Component comp : components) {
            compImportor.importComponent(comp.getId(), comp.getVersion(), projectInfo.getProjectPath());
        }
        
    }
    
	public void generateIdeaProject(String projectPath) {
		
		//生成文件目录和基本配置文件
		FileSystemGenerator fsg = new FileSystemGenerator();
		fsg.generateFileSystem(
				"E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/filesystem/ideaweb.xml", 
				projectPath, 
				"testideagen");
		
		//导入组件
		
		
		EclipseProjectGenerator gen = new EclipseProjectGenerator();
		//生成.project文件
		gen.generateDotProjectFile("testideagen", projectPath);
		//生成.classpath文件
		gen.generateDotClasspathFile(projectPath);
		
		//创建Tomcat Context文件
	}
}
