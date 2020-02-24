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
 * @content	�ý����� ����� Utils ���� ����
 *
 */
public class CommonUtils {

	// ���ڿ���  JSONMap ���·� ��ȯ�Ͽ� ����� ��ȯ�Ѵ�.
	public static Map<String, Object> convertToJSONMap(String str) {
		
		Map<String, Object> retValue = new HashMap<>();
		
		// 0. ���޹��� ���ڿ��� �������� ���� ���
		if(str != null) {
			
		}
		
		// 1. ���޹��� ���ڿ��� �����ϴ� ���
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
