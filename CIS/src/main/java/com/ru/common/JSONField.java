package com.ru.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONField {

	int length()			default 0;		//	등록된 전문 레이아웃 기준 사이즈
	String key()			default "";		//	등록된 전문 레이아웃 기준 전문명
	
	boolean isTrnsClss() 	default false;	//	거래구분코드 여부
	boolean isPkYN()        default false;  //	PK 여분
	boolean isSaveDB()      default true;	// 	DB 적재 여부
	boolean isRuleCol()		default true;	//	Rule 사용 항목 여부
	
}
