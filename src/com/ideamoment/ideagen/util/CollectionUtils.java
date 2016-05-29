/*
 * IDEAGEN是IDEAEE开发平台的代码生成器，项目的目标是帮助生成IdeaMoment团队在开发各种项目时所需要的基础代码。
 * 版权归属北京创想时刻信息技术有限公司所有。
 * 
 * Copyright @ 2011 - 2012 www.ideamoment.com All right reserved.
 */
package com.ideamoment.ideagen.util;

import java.util.List;

/**
 * @author Chinakite Zhang
 *
 */
public class CollectionUtils {
	public static boolean listHasChildren(List list) {
		if(list != null && list.size() > 0) {
			return true;
		}else{
			return false;
		}
	}
}
