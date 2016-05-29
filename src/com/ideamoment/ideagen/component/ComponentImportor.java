/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.component;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.joox.JOOX;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ideamoment.ideagen.component.configuration.AddTask;
import com.ideamoment.ideagen.component.configuration.Component;
import com.ideamoment.ideagen.component.configuration.ComponentResource;
import com.ideamoment.ideagen.component.configuration.CopyTask;
import com.ideamoment.ideagen.component.configuration.Depend;
import com.ideamoment.ideagen.component.configuration.Dependencies;
import com.ideamoment.ideagen.component.configuration.ExecuteTask;
import com.ideamoment.ideagen.component.configuration.IdRef;
import com.ideamoment.ideagen.component.configuration.TagRef;

/**
 * @author Chinakite Zhang
 *
 */
public class ComponentImportor {
	
	private String repositoryPath = null;
	private Set<String> importedComponent = new HashSet<String>();
	
	public boolean importComponent(String id, String version, String projectPath) {
		String componentPath = repositoryPath + File.separator + id + File.separator + version;
		
		Component component = loadComponent(id, version);
		
		try {
			Dependencies dependencies = component.getDependencies();
			if(dependencies != null) {
				List<Depend> depends = dependencies.getDepends();
				if(depends != null) {
					for(Depend depend : depends) {
						String dependId = depend.getId();
						if(importedComponent.contains(dependId)) {
							continue;
						}else{
							String dependVersion = depend.getVersion();
							importComponent(dependId, dependVersion, projectPath);
						}
					}
				}
			}
			
			List<CopyTask> copyTasks = component.getIntegrate().getCopies();
			for(CopyTask task : copyTasks) {
				String to = task.getTo();
				List<IdRef> idRefs = task.getIdRefs();
				if(idRefs != null) {
					for(IdRef idref : idRefs) {
						String value = idref.getValue();
						ComponentResource resource = component.getElementById(value);
						if("file".equals(resource.getResourceType())){
							FileUtils.copyFileToDirectory(new File(componentPath + File.separator + resource.getPath()), new File(projectPath + File.separator + to));
						}else{
							FileUtils.copyDirectoryToDirectory(new File(componentPath + File.separator + resource.getPath()), new File(projectPath + File.separator + to));
						}
					}
				}
				
				List<TagRef> tagRefs = task.getTagRefs();
				if(tagRefs != null) {
					for(TagRef tagref : tagRefs) {
						String value = tagref.getValue();
						List<ComponentResource> resources = component.getElementByTag(value);
						for(ComponentResource resource : resources) {
							if("file".equals(resource.getResourceType())){
								FileUtils.copyFileToDirectory(new File(componentPath + File.separator + resource.getPath()), new File(projectPath + File.separator + to));
							}else{
								FileUtils.copyDirectoryToDirectory(new File(componentPath + File.separator + resource.getPath()), new File(projectPath + File.separator + to));
							}
						}
					}
				}
			}
			
			List<AddTask> addTasks = component.getIntegrate().getAdds();
			if(addTasks != null) {
    			for(AddTask task : addTasks) {
    			    String to = task.getTo();
    			    String filetype = task.getFiletype();
    			    if("xml".equals(filetype)) {
    			        File xmlFile = new File(projectPath + File.separator + to);
//    			        FileInputStream fis = new FileInputStream(xmlFile);
    			        
    			        Document document = JOOX.$(xmlFile).child().append(task.getChunk()).document();
    			        
    			        Transformer transformer = TransformerFactory.newInstance().newTransformer();
    			        Result output = new StreamResult(xmlFile);
    			        Source input = new DOMSource(document);

    			        transformer.transform(input, output);
    			        
//    			        Document document = Jsoup.parse(fis, "UTF-8", "", Parser.xmlParser());
//    			        document.select("beans").append(task.getChunk());
//    			        fis.close();
//    			        
//    			        FileOutputStream fos = new FileOutputStream(xmlFile);
//    			        fos.write(document.toString().getBytes());
//    			        fos.close();
    			    }
    			}
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
		
		List<ExecuteTask> executeTasks = component.getIntegrate().getExecutes();
		
		importedComponent.add(id);
		
		return false;
	}
	
	private Component loadComponent(String id, String version) {
		String componentPath = repositoryPath + File.separator + id + File.separator + version;
		
		String componentFilePath = componentPath + File.separator + id + ".xml" ;
		try{
			JAXBContext context = JAXBContext.newInstance(Component.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Component component = (Component)unmarshaller.unmarshal(new File(componentFilePath));
			
			return component;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getRepositoryPath() {
		return repositoryPath;
	}

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}
}
