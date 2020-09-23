package com.delivery.domain;

import java.util.Date;

import com.delivery.common.annotation.Excel;
import com.delivery.common.core.domain.BaseEntity;

/**
 * 卡劵对象 delivery_card
 *
 * @author jcohy
 * @date 2020-09-17
 */
public class DeliveryCard extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 卡编号 */
	@Excel(name = "卡编号")
	private String cardNo;

	/** 卡密码 */
	@Excel(name = "卡密码")
	private String cardPassword;

	/** 开始时间 */
	private Date startTime;

	/** 结束时间 */
	private Date endTime;

	/** 卡状态 */
	private String cardStatus;

	/** 用户名 */
	private String userName;

	/** 电话 */
	private String phone;

	/** 地址 */
	private String address;

	private String cardShop;

	@Excel(name = "二维码链接")
	private String qrLink;

	private String remark;

	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCardShop() {
		return cardShop;
	}

	public void setCardShop(String cardShop) {
		this.cardShop = cardShop;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getQrLink() {
		return qrLink;
	}

	public void setQrLink(String qrLink) {
		this.qrLink = qrLink;
	}

	@Override
	public String toString() {
		return "DeliveryCard{" +
				"id=" + id +
				", cardNo='" + cardNo + '\'' +
				", cardPassword='" + cardPassword + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", cardStatus='" + cardStatus + '\'' +
				", userName='" + userName + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", cardShop='" + cardShop + '\'' +
				", qrLink='" + qrLink + '\'' +
				", remark='" + remark + '\'' +
				", delFlag='" + delFlag + '\'' +
				'}';
	}
}


