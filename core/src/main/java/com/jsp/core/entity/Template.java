package com.jsp.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="template")
public class Template implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="alt_key")
	    private long altKey;
		@Column(name="template_code",unique=true)
	    private String templateCode;
		@Column(name="entity_id")
	    private String entityId;
		@Column(name="template_sub")
	    private String templateSubject;
		@Column(name="template_content")
		private String templateContent;
		@Column(name="placeholder")
		private String placeholder;
		@Column(name="created_date")
		private Date createdDate;
		@Column(name="created_by")
		private String createdBy;
		@Column(name="modified_by")
		private String modifiedBy;
		@Column(name="modified_date")
		private Date modifiedDate;
		public long getAltKey() {
			return altKey;
		}
		public void setAltKey(long altKey) {
			this.altKey = altKey;
		}
		public String getTemplateCode() {
			return templateCode;
		}
		public void setTemplateCode(String templateCode) {
			this.templateCode = templateCode;
		}
		public String getEntityId() {
			return entityId;
		}
		public void setEntityId(String entityId) {
			this.entityId = entityId;
		}
		public String getTemplateSubject() {
			return templateSubject;
		}
		public void setTemplateSubject(String templateSubject) {
			this.templateSubject = templateSubject;
		}
		public String getTemplateContent() {
			return templateContent;
		}
		public void setTemplateContent(String templateContent) {
			this.templateContent = templateContent;
		}
		public String getPlaceholder() {
			return placeholder;
		}
		public void setPlaceholder(String placeholder) {
			this.placeholder = placeholder;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
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
		public Date getModifiedDate() {
			return modifiedDate;
		}
		public void setModifiedDate(Date modifiedDate) {
			this.modifiedDate = modifiedDate;
		}
		@Override
		public String toString() {
			return "Template [altKey=" + altKey + ", templateCode=" + templateCode + ", entityId=" + entityId
					+ ", templateSubject=" + templateSubject + ", templateContent=" + templateContent + ", placeholder="
					+ placeholder + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", modifiedBy="
					+ modifiedBy + ", modifiedDate=" + modifiedDate + "]";
		}
	     
	}
