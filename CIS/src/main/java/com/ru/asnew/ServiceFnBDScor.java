package com.ru.asnew;

import java.util.Map;

import org.apache.log4j.Logger;

public class ServiceFnBDScor {
	
	private static final Logger log = Logger.getLogger(ServiceFnBDScor.class);
	
	private Map<String, Object> jsonMapData;	// Host���� ���޹��� JSON Map Data
	private Map<String, Object> inputData;		// JSON Map Data�� DB �� Rule Alias�� ����ϱ����� ��ȯ Map Data
	
	
	public ServiceFnBDScor(Map<String, Object> jsonMapData) {
		
		super();
		this.jsonMapData = jsonMapData;
	}

	public Map<String, Object> executeCallBDScorService() {
		
		Map<String, Object> retValue = null;
		
		return retValue;
	}

}
