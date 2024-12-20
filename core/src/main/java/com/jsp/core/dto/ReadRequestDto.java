package com.jsp.core.dto;

import java.util.List;

import com.jsp.core.entity.Filter;
import com.jsp.core.entity.Projection;

public class ReadRequestDto {
	private String entityName;
	
	private List<Projection> projections;
	
	private Filter filter;
	
	private String orderBy;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
