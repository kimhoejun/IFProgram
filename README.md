## 기초 환경 구성

### 1. Tomcat 8.5 JNDI 등록 절차

  ###### ⅰ. 필요 lib 등록 : tomcat-jdbc.jar 및 db lib( oracle, ms... ) 
  
  ###### ⅱ. Server.xml 작성( Tomcat )
  
    
     <Resource name="jdbc/myoracle" auth="Container" 
    		       type="javax.sql.DataSource" driverClassName="oracle.jdbc.driver.OracleDriver" 
    		       url="jdbc:oracle:thin:@localhost:1521:orcl"
    		       username="DB_ID" password="DB_PW" maxTotal="20" masIdle="10"
    		       maxWaitMillis = "-1"/>
               
  ###### ⅲ. Context.xml 작성( Tomcat )
  
    <ResourceLink global="jdbc/myoracle" name="jdbc/myoracle" type="javax.sql.DataSource"/>
      
  ###### ⅳ. web.xml( 프로젝트의 web.xml )

    <resource-ref>
  	  <description>DB DataSource</description>
  	  <res-ref-name>jdbc/myoracle</res-ref-name>
  	  <res-type>javax.sql.DataSource</res-type>
  	  <res-auth>Container</res-auth>
  	  <res-sharing-scope>Shareable</res-sharing-scope>
    </resource-ref>
    
   ###### ⅴ. 프로젝트 spring 구성시( applicationContext.xml )
      
    <bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
      <property name="jndiName">
        <value>jdbc/myoracle</value>
      </property>
        
      <property name="resourceRef">
        <value>true</value>
      </property>
    </bean>
    
 
 ### 2. Sample DB ( Data In/Out CREATE TABLE )
 
 ###### ⅰ. Insert Table
 ```SQL
 CREATE TABLE "KHJDB"."TBINSERVICEA"(
      TRNS_CLSS  VARCHAR2(2 BYTE) NOT NULL ENABLE
    , APPL_DT    VARCHAR2(8 BYTE) NOT NULL ENABLE
    , CUST_NO    VARCHAR2(6 BYTE) NOT NULL ENABLE
    , LOAN_AMT   NUMBER(13, 0)
    , PROC_ACTON VARCHAR2(20 BYTE)
);

CREATE UNIQUE INDEX "KHJDB"."TBINSERVICEA_PK" ON "KHJDB"."TBINSERVICEA" (TRNS_CLSS, APPL_DT, CUST_NO);

COMMENT ON COLUMN "KHJDB"."TBINSERVICEA".TRNS_CLSS   IS '거래구분코드';
COMMENT ON COLUMN "KHJDB"."TBINSERVICEA".APPL_DT     IS '상담일';
COMMENT ON COLUMN "KHJDB"."TBINSERVICEA".CUST_NO     IS '고객번호';
COMMENT ON COLUMN "KHJDB"."TBINSERVICEA".LOAN_AMT    IS '대출금액';
COMMENT ON COLUMN "KHJDB"."TBINSERVICEA".PROC_ACTON  IS '처리일시';

COMMENT ON TABLE "KHJDB"."TBINSERVICEA" IS 'SERVICEA 입력 테이블';
```
 
  
  
