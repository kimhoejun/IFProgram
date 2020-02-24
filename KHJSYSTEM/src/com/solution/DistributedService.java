package com.solution;

import java.util.HashMap;
import java.util.Map;

import com.solution.msg.CommonMsg;

public class DistributedService {
	
	private Map<String, Object> indataMap;
	
	// Web을 통해 전달받은 Map 데이터 set의 재정의 역할 수행
	public DistributedService(Map<String, Object> jsonMap) {
		super();
		// TODO Auto-generated constructor stub
		
		this.indataMap = jsonMap;
	}

	// 1. 실제 Solution 실행 및 서비스 분기 담당
	public Map<String, Object> executeSolution() {
		
		Map<String, Object> retValue = new HashMap<String, Object>();
		
		if(indataMap == null) {
			
		}
		
		// 거래구분 코드에 따라 분기될 서비스 정의
		String trnsClss = indataMap.get("").toString();

		if(trnsClss != CommonMsg.BIZ_ERRCODE99) {
			
			// 거래구분 코드가 "01" 일시 회원평점 service 분기
			if(trnsClss.equals(CommonMsg.BIZ_ERRCODE01)) {
			
				BDScorCallService bdScor = new BDScorCallService(indataMap);
				// -----------------------------------------------------------
				// 1-2. 업무 개별부
				// -----------------------------------------------------------
				retValue.put(CommonMsg.DATA, bdScor.executeSolutionBDScor());
				
				bdScor.rlease();
			}
			// 거래구분 코드가 "12" 일시 회원평점 service 분기
			else if(trnsClss.equals(CommonMsg.BIZ_ERRCODE02)) {
				
			}
		}
		// -----------------------------------------------------------
		// 1-1. 공통 헤더부
		// -----------------------------------------------------------
		retValue.put(CommonMsg.HEADER , "");
		
		// -----------------------------------------------------------
		// 1-3. 메시지부
		// -----------------------------------------------------------
		retValue.put(CommonMsg.MESSAGE, "");
		
		return retValue;
	}
}
