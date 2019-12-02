package com.as;

import java.util.LinkedHashMap;
import java.util.Map;

import com.utils.CommonMsg;
import com.utils.CommonUtils;
import com.vo.InBDScorVo;

public class DistributedService {
	
	private Map<String, Object> IN_MAP  = null;
	private Map<String, Object> KEY_MAP = null;
	
	public DistributedService(Map<String, Object> jsonMap) {
			
		// key map
		KEY_MAP = CommonUtils.makePKMap(InBDScorVo.class, jsonMap);
		this.IN_MAP = jsonMap;
	}
	
	
	public Map<String, Object> executeCallService() {
		
		Map<String, Object> retValue = new LinkedHashMap<>();
	
		try {
		
			String sTrnsClss = CommonUtils.getTrnsClssValue(InBDScorVo.class, KEY_MAP);
			
			if(sTrnsClss.length() == 1) {
				sTrnsClss = "0" + sTrnsClss;
			}
			
			if(IN_MAP.get(sTrnsClss).equals(CommonMsg.TRNS_CLSS_01)) {
				
				CallFnBDScor callFn = new CallFnBDScor(IN_MAP);
				retValue.put("DATA", callFn.executeService());
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return retValue;
	}
	
	
	public void release() {
		
		if(IN_MAP != null) {
			
			IN_MAP = null;
		}
	}
}
