/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.component;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

/**
 * @author Chinakite Zhang
 *
 */
public class SqlExecutor {
	public void execute(Connection conn, String sqlPath) {
		try {
			String sqlContent = FileUtils.readFileToString(new File(sqlPath));
			String[] sqls = sqlContent.split(";");
			for(String sql : sqls) {
				sql = sql.trim();
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
				stmt.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
