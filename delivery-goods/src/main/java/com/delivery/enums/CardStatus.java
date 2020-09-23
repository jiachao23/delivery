package com.delivery.enums;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/21:18:35
 * @since 1.0.0
 */
public enum CardStatus {

	/**
	 * 待生成
	 */
	NOT_HANDLER("card_status", "待生成", ""),

	/**
	 * 已生成
	 */
	NOT_WRITE_OFF("card_status", "已生成", ""),

	/**
	 * 已核销
	 */
	WRITE_OFF("card_status", "已核销", "");


	private String label;

	private String key;

	private String value;

	CardStatus(String key, String label, String value) {
		this.label = label;
		this.key = key;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
