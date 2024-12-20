package com.jsp.integration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Costumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="u_id")
	private long uniqueId;
	@Column(name="user_name")
	private String userName;
	@Column(name="tele_number")
	private String teleNumber;
	@Column(name="sms_status")
	private String smsStatus;
	public long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}
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
	
}