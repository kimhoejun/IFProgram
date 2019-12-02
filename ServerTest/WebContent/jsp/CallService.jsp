<?xml version="1.0" encoding="EUC-KR" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
<jsp:directive.page import="java.util.LinkedHashMap"/>
<jsp:directive.page import="com.utils.CommonUtils"/>
<jsp:directive.page import="java.util.HashMap"/>
<jsp:directive.page import="java.util.Map"/>
<jsp:directive.page import="com.as.DistributedService"/>
<jsp:directive.page import="java.net.URLDecoder"/>
<jsp:directive.page import="java.io.InputStreamReader"/>
<jsp:directive.page import="java.io.BufferedReader"/>
	<jsp:directive.page contentType="text/html; charset=EUC-KR" 
		pageEncoding="EUC-KR" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CallService</title>
</head>
<body>

<%
	request.setCharacterEncoding("euc-kr");
	String jsonReqMsg = "", jsonResMsg = "";

	try {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "euc-kr"));
	
		String inputLine = "";
		while((inputLine = reader.readLine()) != null) {
		
			jsonReqMsg += inputLine.trim();
		}
	
		jsonReqMsg = URLDecoder.decode(jsonReqMsg, "euc-kr");
	
		System.out.println("----------------------------------------------");
		System.out.println("--- euc-kr input data : " + jsonReqMsg);
		System.out.println("----------------------------------------------");
	
		
		Map<String, Object> paramData = CommonUtils.strToMap(jsonReqMsg);
		DistributedService service    = new DistributedService(paramData);
		
		Map<String, Object> retMap = service.executeCallService();	
	
		//create [full text] - header, message, [data]
		//LinkedHashMap<String, Object> data = ServerUtils.convertLinkedHashMap(retMap.get(""));
		jsonResMsg = "";

	
		System.out.println("----------------------------------------------");
		System.out.println("--- Result data JSP : [ " + jsonResMsg + " ]");
		System.out.println("----------------------------------------------");
	
	} catch(Exception e) {
	
		e.printStackTrace();
		e.getMessage();
	}

	out.print(jsonResMsg);
%>
</body>
</html>
</jsp:root>