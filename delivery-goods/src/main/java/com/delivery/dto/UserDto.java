package com.delivery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/18:10:25
 * @since 1.0.0
 */
public class UserDto implements Serializable {

	@NotEmpty(message = "用户名不能为空")
	private String username;

	@NotEmpty(message = "手机号不能为空")
	private String phone;

	@NotEmpty(message = "地址不能为空")
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
