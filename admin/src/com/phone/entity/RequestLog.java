package com.phone.entity;

import java.util.Date;

public class RequestLog {
	private String id;

	private String requestClass;

	private String requestMethod;

	private String requestArgs;

	private Long dealTime;

	private Date requestTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRequestClass() {
		return requestClass;
	}

	public void setRequestClass(String requestClass) {
		this.requestClass = requestClass == null ? null : requestClass.trim();
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod == null ? null : requestMethod
				.trim();
	}

	public String getRequestArgs() {
		return requestArgs;
	}

	public void setRequestArgs(String requestArgs) {
		this.requestArgs = requestArgs == null ? null : requestArgs.trim();
	}

	public Long getDealTime() {
		return dealTime;
	}

	public void setDealTime(Long dealTime) {
		this.dealTime = dealTime;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	@Override
	public String toString() {
		return "RequestLog [dealTime=" + dealTime + ", id=" + id
				+ ", requestArgs=" + requestArgs + ", requestClass="
				+ requestClass + ", requestMethod=" + requestMethod
				+ ", requestTime=" + requestTime + "]";
	}

}