package com.ru.asnew;

import java.util.Map;

import org.apache.log4j.Logger;

public class DistributedService {
	
	private static final Logger log = Logger.getLogger(DistributedService.class);
	
	private static String TRNS_CLSS = "";
	private Map<String, Object> jsonMapData;
	
	
	public DistributedService(Map<String, Object> jsonMap) {
		
		super();
		this.jsonMapData = jsonMap;
	}
	
	
	public Map<String, Object> executeServiceCall() {
		
		Map<String, Object> retValue = null;
		
		// 거래구분 코드 정의 (Host에서 전달하는 JsonMap 데이터중, 거래구분 코드를 구분하여 서비스 분리 실행하기 위해)
		TRNS_CLSS = jsonMapData.get("").toString().trim();
		
		if(TRNS_CLSS.length() == 1) {
			
			TRNS_CLSS = "0" + TRNS_CLSS;
		}
		
		try {
			
			// 회원평점 서비스 구분
			if(TRNS_CLSS.equals("01") || TRNS_CLSS.equals("01")) {
				
				ServiceFnBDScor bdScor = new ServiceFnBDScor(jsonMapData);
				retValue = bdScor.executeCallBDScorService();
			}
			else {
				
				// KSException 
				throw new Exception();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return retValue;
	}
	
	
}
