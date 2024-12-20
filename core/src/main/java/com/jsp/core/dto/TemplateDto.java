package com.jsp.core.dto;

import java.io.Serializable;
import java.util.List;

public class TemplateDto implements Serializable{
	  private String templateCode;	
	  private String entityId;
	  private String templateSubject;
	  private String templateContent;
	  private List<PlaceHolderDto> placeholder;
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
	public List<PlaceHolderDto> getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(List<PlaceHolderDto> placeholder) {
		this.placeholder = placeholder;
	}

}
