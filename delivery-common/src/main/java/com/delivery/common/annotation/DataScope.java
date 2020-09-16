package com.delivery.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据权限过滤注解
 * @author jiac
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
	/**
	 * 部门表的别名
	 */
	String deptAlias() default "";

	/**
	 * 用户表的别名
	 */
	String userAlias() default "";

	/**
	 * 过滤方式
	 */
	Type type() default Type.PRIMARY_KEY;

	/**
	 * Entity 中与部门关联的字段名称
	 * @return /
	 */
	String joinName() default "";

	/**
	 * Entity 中的字段名称
	 */
	String fieldName() default "";

	enum Type {
		// 主键
		PRIMARY_KEY
		// 非主键
		, UNIQUE_KEY
	}

}