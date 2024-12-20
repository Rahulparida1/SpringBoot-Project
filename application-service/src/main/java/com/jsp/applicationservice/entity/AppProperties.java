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
@Table(name="app_properties")
public class AppProperties implements Serializable{
	@Id
	@Column(name="alt_key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int altKey;
	@Column(name="module_name" , nullable = false)
	private String moduleName;
	@Column(name="property_key" , unique = true)
	private String propertyKey;
	@Column(name="property_value" , nullable = false)
	private String propertyValue;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="modified_date")
	private Date modifiedDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="modified_by")
	private String modifiedBy;
	public int getAltKey() {
		return altKey;
	}
	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getPropertyKey() {
		return propertyKey;
	}
	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
