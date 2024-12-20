package com.jsp.core.entity;

import java.util.List;

public class Clauses {
	private String type;
	private List<Predicates> predicates;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Predicates> getPredicates() {
		return predicates;
	}
	public void setPredicates(List<Predicates> predicates) {
		this.predicates = predicates;
	}

}
