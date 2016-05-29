/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.ideamoment.ideagen.model.ProjectInfo;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Chinakite
 *
 */
public class TomcatContextFileGenerator {
    
    public void generateTomcatContextFile(ProjectInfo proInfo) {
        String serverRootPath = proInfo.getDeployInfo().getServerRootPath();
        if(serverRootPath.endsWith("/") || serverRootPath.endsWith("\\")) {
        }else{
            serverRootPath += "/";
        }
        
        String contextFilePath = serverRootPath + "conf/Catalina/localhost/" + proInfo.getProjectName().toLowerCase() + ".xml";
        
        String projectPath = proInfo.getProjectPath();
        if(projectPath.endsWith("/") || projectPath.endsWith("\\")) {
        }else{
            projectPath += "/";
        }
        String webRootPath = projectPath + "WebRoot";
        
        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File("E:/iWorkspace/java/ideagen/src/com/ideamoment/ideagen/templates/tomcat"));
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            
            // 创建根哈希表
            Map root = new HashMap();
            root.put("webRootPath", webRootPath);
            
            Template temp = cfg.getTemplate("context.xml.ftl");
            
            Writer out = new OutputStreamWriter(new FileOutputStream(new File(contextFilePath)), "UTF-8");
            temp.process(root, out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
