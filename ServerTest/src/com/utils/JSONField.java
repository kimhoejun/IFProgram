package com.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface JSONField {
	
	String  key()        default "";
	int     length()     default 0;
	
	boolean TrnsClssYN() default false;
	boolean pkYN()		 default false;
	boolean saveDB()     default true;
	boolean loadValue()  default true;
}
