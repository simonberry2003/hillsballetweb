package com.hillsballetschool.field;

import java.io.Serializable;

import com.google.common.base.Preconditions;

@SuppressWarnings("serial")
public class Field implements Serializable {
	
	private final String name;
	private final Integer length;
	
	public Field(String name, Integer length) {
		this.name = Preconditions.checkNotNull(name);
		this.length = length;
	}
	
	public Field(String name) {
		this(name, null);
	}

	public String getName() {
		return this.name;
	}

	public Integer getLength() {
		return length;
	}
}
