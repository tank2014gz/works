package com.phone.entity;

import java.util.Date;

public class PhoneCategory {
	private String categoryId;

	private String categoryName;

	private String categoryDesc;

	private Short status;

	private Date createTime;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId == null ? null : categoryId.trim();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "PhoneCategory [categoryDesc=" + categoryDesc + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName
				+ ", createTime=" + createTime + ", status=" + status + "]";
	}

}