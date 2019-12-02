package com.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.utils.CommonDBUtils;
import com.vo.InBDScorVo;

public class OnlineTest {
	
	private static Logger log = Logger.getLogger(OnlineTest.class.getName());
	
	private static String LOCAL = "http://localhost:8080/ServerTest/jsp/CallService.jsp";
	private static String REAL  = "";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			URL url = null;
			if(args[0].equals("L")) {
				url = new URL(LOCAL);
			} else {
				url = new URL(REAL);
			}
			
			if(args.length > 2) {
				System.out.println("------- fileTest---------");
			} else {
				onceTest(args[1], url);
			}
		} catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	
	private static void onceTest(String args, URL url) {
		
		LinkedHashMap<String, Object> data = null;
		
		if(args.equals("01"))      data = getData01();
		else if(args.equals("02")) data = getData02();
		else if(args.equals("91")) data = (LinkedHashMap<String, Object>) makeBulkTest(url, InBDScorVo.class, "TBINSERVICEA");
		else {
			log.debug("-------------------------------------------------");
			log.debug("Biz Error, please chek out the arguments");
			log.debug("-------------------------------------------------");
		}
			
	
		String jsonReqMsg = data.toString();	
		connectionURL(url, jsonReqMsg);
	}
	 
	
	private static void connectionURL(URL url, String jsonReqMsg) {
		
		try {
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "test");
			
			OutputStream os = conn.getOutputStream();
			PrintWriter out = new PrintWriter(os);
			
			System.out.println("-------------------------------------------------");
			System.out.println("before inputData  : " + jsonReqMsg);
			System.out.println("-------------------------------------------------");
		
			out.print(URLEncoder.encode(jsonReqMsg, "euc-kr"));
			
			System.out.println("-------------------------------------------------");
			System.out.println("encoder inputData : " + URLEncoder.encode(jsonReqMsg, "euc-kr"));
			System.out.println("-------------------------------------------------");
			
			out.close();
			
			// Show service result
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "euc-kr"));
			
			StringBuffer buffer = new StringBuffer();
			
			int read= 0;
			char[] cbuff = new char[4096];
			
			while( (read = reader.read(cbuff)) > 0 ) {
				buffer.append(cbuff, 0 ,read);
			}
			
			System.out.println("-------------------------------------------------");
			System.out.println("Result Data : [ " + buffer.toString() + " ]");
			System.out.println("-------------------------------------------------");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// -----------------------------------------------------------------
	// Input sample data 1
	// -----------------------------------------------------------------
	private static LinkedHashMap<String, Object> getData01() {
		
		LinkedHashMap<String, Object> retValue = new LinkedHashMap<>();
		
		retValue.put("trns_clss", "01");
		retValue.put("appl_dt"  , "20190930");
		retValue.put("cust_no"  , "190930");
		retValue.put("loan_amt" , 400000000);
	
		return retValue;
	}
	
	
	// -----------------------------------------------------------------
	// Input sample data 2
	// -----------------------------------------------------------------
	private static LinkedHashMap<String, Object> getData02() {
		
		LinkedHashMap<String, Object> retValue = null;
		
		return retValue;
	}
	
	
	// -----------------------------------------------------------------
	// input bulk data Sample ( Get input data from DB )
	// -----------------------------------------------------------------
	private static <T>Map<String, Object> makeBulkTest(URL url, Class<T> cls, String tableName) {
				
		Map<String, Object> retValue = null;
		
		CommonDBUtils utils = new CommonDBUtils();
		ArrayList<Map<String, Object>> mapList = utils.getDBData(cls, tableName);
		
		String jsonReqMsg = "";
		for(int i = 0 ; i < mapList.size() ; i++) {
			
			retValue = mapList.get(i);
			
			jsonReqMsg = mapList.get(i).toString();
			connectionURL(url, jsonReqMsg);
		}
		
		return retValue;
	}
}
