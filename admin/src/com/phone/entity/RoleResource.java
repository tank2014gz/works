package com.phone.entity;

public class RoleResource {
	private String resourceId;

	private String roleId;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId == null ? null : resourceId.trim();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	@Override
	public String toString() {
		return "RoleResource [resourceId=" + resourceId + ", roleId=" + roleId
				+ "]";
	}

}