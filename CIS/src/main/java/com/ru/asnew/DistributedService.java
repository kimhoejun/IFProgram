package com.ru.asnew;

import java.util.Map;

public class DistributedService {
	
	private Map<String, Object> headerMap;
	private Map<String, Object> indataMap;

	public DistributedService(Map<String, Object> jsonMap) {
		
		super();
		this.indataMap = jsonMap;
	}
	
	public Map<String, Object> executeRuleCall() {
		
		Map<String, Object> retValue = null;
		
		return retValue;
	}
}
