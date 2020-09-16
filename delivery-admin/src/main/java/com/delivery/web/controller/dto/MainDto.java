package com.delivery.web.controller.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/22:18:57
 * @since 1.0.0
 */
public class MainDto implements Serializable {
	private Long totalCount = 0L;

	private Long inventoryCount = 0L;

	private Long printCount = 0L;

	private String inventoryPercent = "0%";

	private String printPercent = "0%";

	private Long addLocalCount = 0L;

	private Long updateLocalCount = 0L;

	private Long addThirdCount = 0L;

	private Long updateThirdCount = 0L;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Long inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public Long getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Long printCount) {
		this.printCount = printCount;
	}

	public String getInventoryPercent() {
		return inventoryPercent;
	}

	public void setInventoryPercent(String inventoryPercent) {
		this.inventoryPercent = inventoryPercent;
	}

	public String getPrintPercent() {
		return printPercent;
	}

	public void setPrintPercent(String printPercent) {
		this.printPercent = printPercent;
	}

	public Long getAddLocalCount() {
		return addLocalCount;
	}

	public void setAddLocalCount(Long addLocalCount) {
		this.addLocalCount = addLocalCount;
	}

	public Long getUpdateLocalCount() {
		return updateLocalCount;
	}

	public void setUpdateLocalCount(Long updateLocalCount) {
		this.updateLocalCount = updateLocalCount;
	}

	public Long getAddThirdCount() {
		return addThirdCount;
	}

	public void setAddThirdCount(Long addThirdCount) {
		this.addThirdCount = addThirdCount;
	}

	public Long getUpdateThirdCount() {
		return updateThirdCount;
	}

	public void setUpdateThirdCount(Long updateThirdCount) {
		this.updateThirdCount = updateThirdCount;
	}

	@Override
	public String toString() {
		return "MainDto{" +
				"totalCount=" + totalCount +
				", inventoryCount=" + inventoryCount +
				", printCount=" + printCount +
				", inventoryPercent='" + inventoryPercent + '\'' +
				", printPercent='" + printPercent + '\'' +
				", addLocalCount=" + addLocalCount +
				", updateLocalCount=" + updateLocalCount +
				", addThirdCount=" + addThirdCount +
				", updateThirdCount=" + updateThirdCount +
				'}';
	}
}
