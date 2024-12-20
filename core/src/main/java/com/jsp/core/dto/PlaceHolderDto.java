package com.jsp.core.dto;

import java.io.Serializable;

public class PlaceHolderDto implements Serializable{
	
	    private String entityFieldName;
	    private String placeholderKey;
		public String getEntityFieldName() {
			return entityFieldName;
		}
		public void setEntityFieldName(String entityFieldName) {
			this.entityFieldName = entityFieldName;
		}
		public String getPlaceholderKey() {
			return placeholderKey;
		}
		public void setPlaceholderKey(String placeholderKey) {
			this.placeholderKey = placeholderKey;
		}

}
