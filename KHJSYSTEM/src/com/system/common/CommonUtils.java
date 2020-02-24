package com.system.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author 	kimhoejun
 * @date	2020.02.04
 * @content	시스템의 공통된 Utils 관리 정의
 *
 */
public class CommonUtils {

	// 문자열을  JSONMap 형태로 변환하여 결과를 반환한다.
	public static Map<String, Object> convertToJSONMap(String str) {
		
		Map<String, Object> retValue = new HashMap<>();
		
		// 0. 전달받은 문자열이 존재하지 않을 경우
		if(str != null) {
			
		}
		
		// 1. 전달받은 문자열이 존재하는 경우
		try {
	
			retValue = new ObjectMapper().readValue(JSON_SOURCE, HashMap.class);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public static String makeJSONResultMessage(LinkedHashMap<String, Object> header
											 , LinkedHashMap<String, Object> message
											 , LinkedHashMap<String, Object> data) {
		
		String retValue = "";
		
		return retValue;
	}
}
