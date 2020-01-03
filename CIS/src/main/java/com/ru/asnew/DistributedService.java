package com.ru.asnew;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class DistributedService {
	
	private static final Logger log = Logger.getLogger(DistributedService.class);
	
	private static String TRNS_CLSS;	//	Host�� ���޹��� jsonMap ������ �������� �ŷ����� �ڵ� �� ���� ����
	
	private Map<String, Object> jsonMapData;
	
	
	public DistributedService(Map<String, Object> jsonMap) {
		
		super();
		this.jsonMapData = jsonMap;
	}
	
	//	�ŷ����� �ڵ忡 ���� ���� �б� ����
	public Map<String, Object> executeServiceCall() {
		
		log.info("=========================================================");
		log.info("executeServiceCall interface [ " + "(I/F ID)" + " ]");
		log.info("=========================================================");
		
		Map<String, Object> retValue = new LinkedHashMap<String, Object>();
		
		// �ŷ����� �ڵ� ���� (Host���� �����ϴ� JsonMap ��������, �ŷ����� �ڵ带 �����Ͽ� ���� �и� �����ϱ� ����)
		TRNS_CLSS = jsonMapData.get("").toString().trim();
		
		if(TRNS_CLSS.length() == 1) {
			
			TRNS_CLSS = "0" + TRNS_CLSS;
		}
		
		try {
			
			// ȸ������ ���� ����
			if(TRNS_CLSS.equals("01") || TRNS_CLSS.equals("01")) {
				
				ServiceFnBDScor bdScor = new ServiceFnBDScor(jsonMapData);
				retValue.put("DATA", bdScor.executeCallBDScorService());
				
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
