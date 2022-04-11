package com.atguigu.utils;


import java.util.Map;


import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	
	public static <T> T copyParamToBean(Map map ,T bean) {
		
		try {
			BeanUtils.populate(bean, map);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return bean;
		
	}
	
	public static int parseInt(String strInt, int defaultValue) {
		try {
			return Integer.parseInt(strInt);
		}catch (Exception e) {
//			e.printStackTrace();
		}
		
		return defaultValue;
	}
	

}
