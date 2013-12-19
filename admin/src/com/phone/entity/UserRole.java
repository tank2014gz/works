package com.phone.entity;

public class UserRole {
	private String roleId;

	private String userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", userId=" + userId + "]";
	}

}