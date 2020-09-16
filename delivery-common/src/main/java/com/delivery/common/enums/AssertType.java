package com.delivery.common.enums;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/27:17:58
 * @since 1.0.0
 */
public enum AssertType {
	/**
	 * 资产类型
	 */
	FIXED(1, ""),
	CONSUMABLE(2, "");

	private Integer code;

	private String name;

	AssertType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
