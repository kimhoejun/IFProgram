<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.system.common.CommonUtils"%>
<%@page import="com.solution.DistributedService"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Map" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
			
			// ���޹��� jsonMap������ �����͸� ���� �б� 
			Map<String, Object> jsonMap = CommonUtils.convertToJSONMap(jsonReqMsg);
			
			// service ����
			DistributedService service  = new DistributedService(jsonMap);
			
			// service �������� ���� ��� ��ȯ
			LinkedHashMap<String, Object> header	 = new LinkedHashMap<>();
			LinkedHashMap<String, Object> resultMsg	 = new LinkedHashMap<>();
			LinkedHashMap<String, Object> resultData = new LinkedHashMap<>();
			
			jsonResMsg = CommonUtils.makeJSONResultMessage(header, resultMsg, resultData);
			
			System.out.println("====================================================================================");
			System.out.println("EUC-KR Output data : " + jsonResMsg);
			System.out.println("====================================================================================");
		} 
		catch(Exception e) {
			
			e.printStackTrace();
			e.getMessage();
		}
	%>

</body>
</html>