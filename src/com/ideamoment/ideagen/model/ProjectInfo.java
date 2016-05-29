/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.model;

import java.util.ArrayList;
import java.util.List;

import com.ideamoment.ideagen.component.configuration.Component;

/**
 * @author Chinakite
 *
 */
public class ProjectInfo {
    
    private String projectName;
    
    private String projectPath;
    
    private List<Component> components = new ArrayList<Component>();
    
    private List<ProjectDbInfo> dbInfoes = new ArrayList<ProjectDbInfo>();
    
    private ProjectDeployInfo deployInfo;
    
    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    /**
     * @return the projectPath
     */
    public String getProjectPath() {
        return projectPath;
    }
    
    /**
     * @param projectPath the projectPath to set
     */
    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
    
    /**
     * @return the components
     */
    public List<Component> getComponents() {
        return components;
    }
    
    /**
     * @param components the components to set
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }
    
    /**
     * @return the dbInfoes
     */
    public List<ProjectDbInfo> getDbInfoes() {
        return dbInfoes;
    }

    /**
     * @param dbInfoes the dbInfoes to set
     */
    public void setDbInfoes(List<ProjectDbInfo> dbInfoes) {
        this.dbInfoes = dbInfoes;
    }

    public void addDbInfo(ProjectDbInfo dbInfo) {
        this.dbInfoes.add(dbInfo);
    }
    
    /**
     * @return the deployInfo
     */
    public ProjectDeployInfo getDeployInfo() {
        return deployInfo;
    }
    
    /**
     * @param deployInfo the deployInfo to set
     */
    public void setDeployInfo(ProjectDeployInfo deployInfo) {
        this.deployInfo = deployInfo;
    }
}
