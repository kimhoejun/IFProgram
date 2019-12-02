package com.connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.vo.DBConfigVo;


public class ConnectDBMng {

	private final static String CONFIG = "C:/workspace/ClientTest/src/com/setting/properties/db.properties";
	
	private static Connection conn     = null;
	private static Properties prop     = null;
	private static DBConfigVo configVo = null;

	public ConnectDBMng() {
		
		configVo = new DBConfigVo();
	}
	
	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		ConnectDBMng.conn = conn;
	}
	
	public static Connection getConnection() {

		String errMsg = "";
		
		try {
			prop = new Properties();
			
			BufferedReader reader = new BufferedReader(new FileReader(CONFIG));
			prop.load(reader);
		
			configVo = new DBConfigVo();
			
			configVo.setDriver(prop.getProperty("driver"));
			configVo.setUrl(prop.getProperty("url"));
			configVo.setUser(prop.getProperty("user"));
			configVo.setPassword(prop.getProperty("password"));
			
			System.out.println("==============================================================");
			System.out.println(" driver   : " + configVo.getDriver());
			System.out.println(" url      : " + configVo.getUrl());
			System.out.println(" user     : " + configVo.getUser());
			System.out.println(" passowrd : " + configVo.getPassword());
			System.out.println("==============================================================");
			
			Class.forName(configVo.getDriver()).newInstance();
			conn = DriverManager.getConnection(configVo.getUrl(), configVo.getUser(), configVo.getPassword());
			
		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();
			errMsg = e.getMessage();
			System.out.println("==============================================================");
			System.out.println("ClassNotFoundException : " + errMsg);
			System.out.println("==============================================================");
		} 
		catch (SQLException e) {

			e.printStackTrace();
			errMsg = e.getMessage();
			System.out.println("==============================================================");
			System.out.println("SQLException : " + errMsg);
			System.out.println("==============================================================");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			errMsg = e.getMessage();
			System.out.println("==============================================================");
			System.out.println("IOException : " + errMsg);
			System.out.println("==============================================================");
		}
	
		return conn;
	}
	
	// close ConnectionDB resource
	public static void close() {
		
		if(conn != null) {
			try {
				
				conn.close();
				System.out.println("Connection is closed...");
			} catch (SQLException e) {
				
				e.printStackTrace();
				e.getMessage();
			}
		}
	}

}