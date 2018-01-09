package com.suturn.framework.core.entity;

import java.lang.annotation.*;

/**
 * 日志记录注解
 * @author Administrator
 * @version 创建时间：2017年1月12日下午2:19:29
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceOperationLog {

	public String type();
}
