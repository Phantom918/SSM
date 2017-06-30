package com.qin.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CustomerValidator
public @interface DateString {

	String pattern() default "yyyy-mm-dd HH:mm:ss";// 如果不指定pattern这个值的时候将返回默认值“yyyy-MM-dd HH:mm:ss” 
	
	String errorcode() default "must date";
	
	String message() default "must be date pattern";
	
	
}
