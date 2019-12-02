package com.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.connect.ConnectDBMng;
import com.dao.DBCallQuery;

public class CommonDBUtils {
	
	private Statement stmt  = null;
	private ResultSet rs    = null;

	public CommonDBUtils() {
	
		super();
	}
	
	public <T>ArrayList<Map<String, Object>> getDBData(Class<T> cls, String tableName) {
		
		String sql = "";
		DBCallQuery query = new DBCallQuery();
		
		ArrayList<Map<String, Object>> retValue = new ArrayList<>();
		Map<String, Object> entryMap            = null;
		
		try {

			sql  = query.getSelectData(tableName);
			stmt = ConnectDBMng.getConnection().createStatement();
			rs   = stmt.executeQuery(sql);
			
			while(rs.next()) {
			
				entryMap = new HashMap<>();
				
				String sfieldNm = "", sKey = "";
				Object value = "";
		
				for(Field field : cls.getDeclaredFields()) {
					
					JSONField fld = field.getAnnotation(JSONField.class);
					sfieldNm = field.getName();
					sKey     = fld.key().toString();
					value    = rs.getObject(sKey);
					
					entryMap.put(sfieldNm, value);
				}
				retValue.add(entryMap);
				System.out.println("Entry Map : " + entryMap);
			}
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			e.getMessage();
		}
		finally {
			
			try {
				
				if(rs != null) {
					rs.close();
				}
				else if(ConnectDBMng.getConn() != null) {
					ConnectDBMng.close();
				}
			}
			catch (Exception e) {
				
				e.printStackTrace();
				e.getMessage();
			}
		}
		
		return retValue;
	}
	
}
