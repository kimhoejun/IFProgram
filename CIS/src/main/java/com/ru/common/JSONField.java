package com.ru.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONField {

	int length()			default 0;		//	��ϵ� ���� ���̾ƿ� ���� ������
	String key()			default "";		//	��ϵ� ���� ���̾ƿ� ���� ������
	
	boolean isTrnsClss() 	default false;	//	�ŷ������ڵ� ����
	boolean isPkYN()        default false;  //	PK ����
	boolean isSaveDB()      default true;	// 	DB ���� ����
	boolean isRuleCol()		default true;	//	Rule ��� �׸� ����
	
}
