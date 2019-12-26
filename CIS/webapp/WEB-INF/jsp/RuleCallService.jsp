<%@page import="com.ru.common.CommonUtils"%>

<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Map" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Start to the service page</title>
</head>
<body>

	<h1>Start service</h1>
	<%
		request.setCharacterEncoding("EUC-KR");
		String jsonReqMsg = "", jsonResMsg = "";
	
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "EUC-KR"));
			
			String inputLine = "";
			while( (inputLine = reader.readLine()) != null) {
				
				jsonReqMsg += inputLine.trim();
			}
			
			jsonReqMsg = URLDecoder.decode(jsonReqMsg, "EUC-KR");
			
			System.out.println("====================================================================================");
			System.out.println("EUC-KR Input data : " + jsonReqMsg);
			System.out.println("====================================================================================");
			
			/* 전달받은 jsonMap형태의 데이터를 각각 분기 */
			Map<String, Object> jsonMap = CommonUtils.strToMap(jsonReqMsg);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			e.getMessage();
		}
	
	%>
</body>
</html>