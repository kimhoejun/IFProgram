package com.dao;

public class DBCallQuery {
	
	// Defind the select DB query
	public String getSelectData(String tableName) {
	
		String retValue = "";
		
		StringBuilder sDmlstr = new StringBuilder();
		sDmlstr.append("SELECT * FROM ").append(tableName);
		
		retValue = sDmlstr.toString();
		
		return retValue;
	}
}
