package com.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ConnectionDB {

	// Âü°í : https://tomcat.apache.org/tomcat-8.5-doc/jndi-datasource-examples-howto.html
	//    , https://devbox.tistory.com/entry/JSP-%EC%BB%A4%EB%84%A5%EC%85%98-%ED%92%80-1
	
	private static Logger log = Logger.getLogger(ConnectionDB.class.getName());
	
	private static String DRIVER_NM = "oracle.jdbc.driver.oracledriver";
	private static Connection conn = null;
	
	public static void driverCheck() {
		
		try {
			
			Class.forName(DRIVER_NM);
		} catch (ClassNotFoundException  e) {
		
			log.error("Do not have registor Driver");;
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	public static void getConnection() throws IOException {
		// TODO Auto-generated method stub
		
		log.debug("---------- Oracle JDBC Connection ----------");
		
		driverCheck();
		
		try {
			
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds       = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
		
		if (conn != null) {
            log.debug("Connection successful with ATLAS");
        } else {
        	log.error("Failed to make connection!");
        }
	}
	
}
