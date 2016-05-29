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
public class ProjectDbInfo {
    
    public static final int MYSQL = 1;
    
    private String dbName;
    
    private String url;
    
    private String username;
    
    private String password;
    
    private int dbType = 1;

    /**
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }
    
    /**
     * @param dbName the dbName to set
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the dbType
     */
    public int getDbType() {
        return dbType;
    }
    
    /**
     * @param dbType the dbType to set
     */
    public void setDbType(int dbType) {
        this.dbType = dbType;
    }
    
}
