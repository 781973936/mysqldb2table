package com.lanshan.mysqldb2table.db;

import java.util.List;

public class Table {
	private String name;
	private String remark;
	
	private List<Field> fields;
	
	
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Table(String name, String remark) {
		super();
		this.name = name;
		this.remark = remark;
	}
	
	public Table(String name, String remark, List<Field> fields) {
		super();
		this.name = name;
		this.remark = remark;
		this.fields = fields;
	}
	@Override
	public String toString() {
		return "Table [name=" + name + ", remark=" + remark + ", fields=" + fields + "]";
	}
	
}	
