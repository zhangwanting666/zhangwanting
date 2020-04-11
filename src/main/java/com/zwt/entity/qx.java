package com.zwt.entity;

public class qx {

	private String value;
	private String title;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public qx(String value, String title) {
		super();
		this.value = value;
		this.title = title;
	}
	public qx() {
		super();
	}
	@Override
	public String toString() {
		return "qx [value=" + value + ", title=" + title + "]";
	}
	
}
