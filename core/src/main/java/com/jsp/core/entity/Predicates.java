package com.jsp.core.entity;

import java.util.List;

public class Predicates {
    private String dimension;
    private String operator;
    private String value;
    private List<Object> range;
    private List<String> list;
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Object> getRange() {
		return range;
	}
	public void setRange(List<Object> range) {
		this.range = range;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}

}
