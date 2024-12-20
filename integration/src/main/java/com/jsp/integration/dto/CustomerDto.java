package com.jsp.integration.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable{
	private String userName;
	private String teleNumber;
	private String smsStatus;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeleNumber() {
		return teleNumber;
	}
	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}
	public String getSmsStatus() {
		return smsStatus;
	}
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}
	@Override
	public String toString() {
		return "CustomerDto [userName=" + userName + ", teleNumber=" + teleNumber + ", smsStatus=" + smsStatus + "]";
	}

}
