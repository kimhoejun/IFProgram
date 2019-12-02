package com.as;

import java.util.Map;

import com.utils.CommonUtils;
import com.vo.InBDScorVo;

public class CallFnBDScor {
	
	private Map<String, Object> IN_MAP   = null;
	private Map<String, Object> KEY_MAP  = null;
	
	private InBDScorVo InputVo           = null;
	private Map<String, Object> InputMap = null;
	
	
	public CallFnBDScor(Map<String, Object> jsonMap) {
				
		// key map
		KEY_MAP = CommonUtils.makePKMap(InBDScorVo.class, jsonMap);
		this.IN_MAP = jsonMap;
	}
	
	
	public Map<String, Object> executeService() {
		
		Map<String, Object> retValue = null;
		
		try {
			
			if( !checkedValue(IN_MAP) ) {
			}
			
			if( !checkKeyValue(KEY_MAP) ) {

			}
			
			// convert json data To map
			InputVo  = (InBDScorVo)CommonUtils.makeMarshalVo(InBDScorVo.class, IN_MAP);
			InputMap = CommonUtils.makeJsonToMap(InBDScorVo.class, InputVo);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		
		return retValue;
	}
	
	
	// -------------------------------------------------------------------	
	// Check the received data is empty
	// -------------------------------------------------------------------
	private static boolean checkedValue(Map<String, Object> inputMap) {
		
		boolean retValue = true;
		
		if(inputMap != null) {
			retValue = true;
		} else {
			retValue = false;
		}
		
		return retValue;
	}
	
	
	// -------------------------------------------------------------------
	// Check the received data key is empty
	// -------------------------------------------------------------------
	private static boolean checkKeyValue(Map<String, Object> keyMap) {
		
		boolean retValue = true;
		
		if(keyMap != null) {
			retValue = true;
		} else {
			retValue = false;
		}
		
		return retValue;
	}

}