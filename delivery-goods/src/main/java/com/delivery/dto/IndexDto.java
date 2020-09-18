package com.delivery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/18:15:57
 * @since 1.0.0
 */
public class IndexDto implements Serializable {

	@NotEmpty(message = "不能为空")
	private String cardNo;

	private String userName;

	private String cardPassword;

	private String address;

	private String phone;

	private String remark;

	private String province;

	private String city;

	private String area;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardPassword() {
		return cardPassword;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "IndexDto{" +
				"cardNo='" + cardNo + '\'' +
				", userName='" + userName + '\'' +
				", cardPassword='" + cardPassword + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", remark='" + remark + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", area='" + area + '\'' +
				'}';
	}
}
