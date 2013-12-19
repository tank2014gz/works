package com.phone.entity;

import java.util.Date;

public class Phone {
	private String phone;

	private String userId;

	private Short status;

	private Integer categoryId;

	private Long costPrice;

	private Long sellPrice;

	private String priceMark;

	private String memo;

	private Date cretaeTime;

	private Date modifyTime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Long costPrice) {
		this.costPrice = costPrice;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getPriceMark() {
		return priceMark;
	}

	public void setPriceMark(String priceMark) {
		this.priceMark = priceMark == null ? null : priceMark.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public Date getCretaeTime() {
		return cretaeTime;
	}

	public void setCretaeTime(Date cretaeTime) {
		this.cretaeTime = cretaeTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "Phone [categoryId=" + categoryId + ", costPrice=" + costPrice
				+ ", cretaeTime=" + cretaeTime + ", memo=" + memo
				+ ", modifyTime=" + modifyTime + ", phone=" + phone
				+ ", priceMark=" + priceMark + ", sellPrice=" + sellPrice
				+ ", status=" + status + ", userId=" + userId + "]";
	}

}