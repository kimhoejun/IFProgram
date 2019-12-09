package com.ru.common;

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
	
}
