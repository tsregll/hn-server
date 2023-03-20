package com.ruoyi.business.monitorUtil.mapper;

import java.util.ArrayList;

public class Expressions {
	private String key;
	private Integer operator;
	private ArrayList<String> values;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public void setValues(ArrayList<String> values) {
		this.values = values;
	}
}
