package com.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {
	
	private static int KEY_IDX   = 0;
	private static int VALUE_IDX = 1;
	
	// ----------------------------------------------------------------------
	// convert String To map
	// ----------------------------------------------------------------------
	public static Map<String, Object> strToMap(String jsonData) {
		
		Map<String, Object> retValue = new HashMap<String, Object>();
		
		String[] strConvert = jsonData.split(",");
		for(String item : strConvert) {
			
			String[] element = item.split("=");
			
			String sKey   = element[KEY_IDX];
			String sValue = element[VALUE_IDX];
			
			retValue.put(sKey, sValue);
		}
		
		return retValue;
	}
	
	

	// ----------------------------------------------------------------------
	// make Key map
	// ----------------------------------------------------------------------
	public static Map<String, Object> makePKMap(Class<?> cls, Map<String, Object> jsonMap) {
		
		Map<String, Object> retValue = new HashMap<>();
		
		String sKey  = "";
		Object value = null;
		
		for(Field field : cls.getDeclaredFields()) {
			
			JSONField fld = field.getDeclaredAnnotation(JSONField.class);
			
			if(fld.pkYN()) {
				
				sKey  = field.getName();
				value = jsonMap.get(sKey);
				
				retValue.put(sKey, value);
			}
		}
		
		return retValue;
	}
	
	
	// ----------------------------------------------------------------------
	// return the [trns clss] code value
	// ----------------------------------------------------------------------
	public static String getTrnsClssValue(Class<?> cls, Map<String, Object> jsonMap) {
		
		String retValue = "";
		
		String sKey  = "";		
		for(Field field : cls.getDeclaredFields()) {
		
			JSONField fld = field.getAnnotation(JSONField.class);
			if(fld.TrnsClssYN()) {
				
				sKey     = field.getName();
				retValue = jsonMap.get(sKey).toString();
			}
		}
		
		return retValue;
	}
	
	// ----------------------------------------------------------------------
	// marshal JSON type data To map
	// ----------------------------------------------------------------------
	public static Object makeMarshalVo(Class<?> cls, Map<String, Object> jsonMap) {
		
		Object retValue = null;
		
		JSONManager manager = new JSONManager();
		retValue = manager.load(cls, jsonMap);
		
		return retValue;
	}
	
	
	// ----------------------------------------------------------------------
	// 
	// ----------------------------------------------------------------------
	public static Map<String, Object> makeJsonToMap(Class<?> cls, Object vo) {
			
		Map<String, Object> retValue = null;

			
		return retValue;
	}
	
}
