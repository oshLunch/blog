package com.cos.reflect.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})	//위치
@Retention(RetentionPolicy.RUNTIME)	//언제
public @interface RequestMapping {
	String value();
}
