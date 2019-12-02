package com.utils;

import java.lang.reflect.Field;
import java.util.Map;

public class JSONManager {
	
	public <T> T load(Class<?> cls, Map<String, Object> jsonMap) {
		
		T retValue = null;
		
		
		for(Field field : cls.getDeclaredFields()) {
			
			JSONField fld = field.getAnnotation(JSONField.class);
		}
		
		return retValue;
	}

}
