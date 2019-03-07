package com.zdy.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
	String logtype() default ""; //模块名称
	String typename() default ""; //业务方法名称
	String author() default ""; //作者
	String logconstants() default ""; //log4j的模块
}