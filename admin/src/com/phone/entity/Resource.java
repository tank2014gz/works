package com.phone.entity;

public class Resource {
	private String resourceId;

	private String rrsourceName;

	private String resourceUrl;

	private Short status;

	private Integer priority;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId == null ? null : resourceId.trim();
	}

	public String getRrsourceName() {
		return rrsourceName;
	}

	public void setRrsourceName(String rrsourceName) {
		this.rrsourceName = rrsourceName == null ? null : rrsourceName.trim();
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Resource [priority=" + priority + ", resourceId=" + resourceId
				+ ", resourceUrl=" + resourceUrl + ", rrsourceName="
				+ rrsourceName + ", status=" + status + "]";
	}

}