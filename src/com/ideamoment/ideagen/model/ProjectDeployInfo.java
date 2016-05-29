/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.model;


/**
 * @author Chinakite
 *
 */
public class ProjectDeployInfo {
    
    public static int TOMCAT = 1;
    
    private int type = TOMCAT;
    
    private String serverRootPath;
    
    /**
     * @return the type
     */
    public int getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * @return the serverRootPath
     */
    public String getServerRootPath() {
        return serverRootPath;
    }

    /**
     * @param serverRootPath the serverRootPath to set
     */
    public void setServerRootPath(String serverRootPath) {
        this.serverRootPath = serverRootPath;
    }
    
    
}
