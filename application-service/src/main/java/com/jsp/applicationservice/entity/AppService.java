package com.jsp.applicationservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="app_service")
public class AppService implements Serializable{
	@Id
	@Column(name="alt_key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int altKey;
	@Column(name="service_name" , unique = true)
	private String serviceName;
	@Column(name="service_url")
	private String serviceUrl;
	@Column(name="status")
	private String status;
	@Column(name="created_date")
    private Date createdDate;
	@Column(name="modified_date")
    private Date modifiedDate;
	public int getAltKey() {
		return altKey;
	}
	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
