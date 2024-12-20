package com.jsp.applicationservice.dto;

import org.springframework.stereotype.Component;

@Component
public class AppResponseDto {
	private String status;
	private String statusCode;
	private Object data;
	private String error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public AppResponseDto() {
		super();
	}
	public AppResponseDto(String status, String statusCode, Object data, String error) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		this.error = error;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "AppResponseDto [status=" + status + ", statusCode=" + statusCode + ", data=" + data + ", error=" + error
				+ "]";
	}

}
