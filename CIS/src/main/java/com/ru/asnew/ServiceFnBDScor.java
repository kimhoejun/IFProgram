package com.ru.asnew;

import java.util.Map;

import org.apache.log4j.Logger;

public class ServiceFnBDScor {
	
	private static final Logger log = Logger.getLogger(ServiceFnBDScor.class);
	
	private Map<String, Object> jsonMapData;	// Host에서 전달받은 JSON Map Data
	private Map<String, Object> inputData;		// JSON Map Data를 DB 및 Rule Alias로 사용하기위해 변환 Map Data
	
	
	public ServiceFnBDScor(Map<String, Object> jsonMapData) {
		
		super();
		this.jsonMapData = jsonMapData;
	}

	public Map<String, Object> executeCallBDScorService() {
		
		Map<String, Object> retValue = null;
		
		return retValue;
	}

}
