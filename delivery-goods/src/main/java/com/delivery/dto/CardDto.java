package com.delivery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/17:16:39
 * @since 1.0.0
 */
public class CardDto implements Serializable {

	@NotNull
	private Integer number;

	@NotNull
	private String name;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
