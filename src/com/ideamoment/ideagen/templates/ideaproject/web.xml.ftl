<?xml version="1.0" encoding="UTF-8"?>
<web-app>   
  
    <display-name>${projectName}</display-name>
    
    <servlet-mapping> 
    	<servlet-name>default</servlet-name> 
    	<url-pattern>*.html</url-pattern> 
	</servlet-mapping>
	<servlet-mapping> 
    	<servlet-name>default</servlet-name> 
    	<url-pattern>*.css</url-pattern> 
	</servlet-mapping>
	<servlet-mapping> 
    	<servlet-name>default</servlet-name> 
    	<url-pattern>*.js</url-pattern> 
	</servlet-mapping>
	<servlet-mapping> 
    	<servlet-name>default</servlet-name> 
    	<url-pattern>*.jpg</url-pattern> 
	</servlet-mapping>
	<servlet-mapping> 
    	<servlet-name>default</servlet-name> 
    	<url-pattern>*.gif</url-pattern> 
	</servlet-mapping>
	<servlet-mapping> 
    	<servlet-name>default</servlet-name> 
    	<url-pattern>*.png</url-pattern> 
	</servlet-mapping>
    
    <servlet> 
	    <servlet-name>springmvc</servlet-name> 
	    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class> 
	    <load-on-startup>1</load-on-startup> 
	</servlet>
	
	<servlet-mapping> 
    	<servlet-name>springmvc</servlet-name> 
    	<url-pattern>/</url-pattern> 
	</servlet-mapping>
	
	<filter> 
 		<filter-name>HiddenHttpMethodFilter</filter-name> 
 		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class> 
	</filter> 
 
	<filter-mapping> 
	 	<filter-name>HiddenHttpMethodFilter</filter-name> 
	 	<servlet-name>springmvc</servlet-name> 
	</filter-mapping>
    
    <welcome-file-list>   
        <welcome-file>/index.html</welcome-file>   
    </welcome-file-list>
    
</web-app>