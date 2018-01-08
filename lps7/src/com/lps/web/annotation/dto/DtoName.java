package com.lps.web.annotation.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*@interface Todo {
public enum Priority {LOW, MEDIUM, HIGH}
public enum Status {STARTED, NOT_STARTED}
String author() default "Yash";
Priority priority() default Priority.LOW;
Status status() default Status.NOT_STARTED;
}*/

/**
 * dto的名字
 * @author 0001
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoName {
	
	String value() default "";
	
}
