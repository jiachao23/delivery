package com.delivery.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/14:15:25
 * @since 1.0.0
 */
public class EmailDto implements Serializable {

	private String to = "jia_chao23@126.com";

	@NotNull(message = "用户名不能为空")
	private String name;

	@NotNull(message = "手机号不能为空")
	private String phone;

	@Email(message = "请输入正确的邮箱")
	private String email;

	private String content;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "name:" + name + "\n" +
				"phone:" + phone + "\n" +
				"email:" + email + "\n" +
				"content:" + content;
	}
}
