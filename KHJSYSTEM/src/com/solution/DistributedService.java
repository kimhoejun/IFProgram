package com.solution;

import java.util.HashMap;
import java.util.Map;

import com.solution.msg.CommonMsg;

public class DistributedService {
	
	private Map<String, Object> indataMap;
	
	// Web�� ���� ���޹��� Map ������ set�� ������ ���� ����
	public DistributedService(Map<String, Object> jsonMap) {
		super();
		// TODO Auto-generated constructor stub
		
		this.indataMap = jsonMap;
	}

	// 1. ���� Solution ���� �� ���� �б� ���
	public Map<String, Object> executeSolution() {
		
		Map<String, Object> retValue = new HashMap<String, Object>();
		
		if(indataMap == null) {
			
		}
		
		// �ŷ����� �ڵ忡 ���� �б�� ���� ����
		String trnsClss = indataMap.get("").toString();

		if(trnsClss != CommonMsg.BIZ_ERRCODE99) {
			
			// �ŷ����� �ڵ尡 "01" �Ͻ� ȸ������ service �б�
			if(trnsClss.equals(CommonMsg.BIZ_ERRCODE01)) {
			
				BDScorCallService bdScor = new BDScorCallService(indataMap);
				// -----------------------------------------------------------
				// 1-2. ���� ������
				// -----------------------------------------------------------
				retValue.put(CommonMsg.DATA, bdScor.executeSolutionBDScor());
				
				bdScor.rlease();
			}
			// �ŷ����� �ڵ尡 "12" �Ͻ� ȸ������ service �б�
			else if(trnsClss.equals(CommonMsg.BIZ_ERRCODE02)) {
				
			}
		}
		// -----------------------------------------------------------
		// 1-1. ���� �����
		// -----------------------------------------------------------
		retValue.put(CommonMsg.HEADER , "");
		
		// -----------------------------------------------------------
		// 1-3. �޽�����
		// -----------------------------------------------------------
		retValue.put(CommonMsg.MESSAGE, "");
		
		return retValue;
	}
}
