package com.phone.entity;

import java.util.Date;

public class Users {
	private String userId;

	private String userName;

	private String password;

	private Integer status;

	private Integer type;

	private Date createTime;

	private Date modifyTime;

	private Short isAdmin;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Short getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Short isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Users [createTime=" + createTime + ", isAdmin=" + isAdmin
				+ ", modifyTime=" + modifyTime + ", password=" + password
				+ ", status=" + status + ", type=" + type + ", userId="
				+ userId + ", userName=" + userName + "]";
	}

}