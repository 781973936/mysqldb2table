package com.lanshan.mysqldb2table.db;

public class Field {
	private String name;
	private String remark;
	private String type;
	private String range;
	private String defaults;
	private String isNull;
	private String isAuto;
	
	public String getDefaults() {
		return defaults;
	}
	public void setDefaults(String defaults) {
		this.defaults = defaults;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getIsNull() {
		return isNull;
	}
	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}
	public String getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(String isAuto) {
		this.isAuto = isAuto;
	}
	
	public Field(String name, String remark, String type, String range, String defaults, String isNull, String isAuto) {
		super();
		this.name = name;
		this.remark = remark;
		this.type = type;
		this.range = range;
		this.defaults = defaults;
		this.isNull = isNull;
		this.isAuto = isAuto;
	}
	@Override
	public String toString() {
		return "Field [name=" + name + ", remark=" + remark + ", type=" + type + ", range=" + range + ", defaults="
				+ defaults + ", isNull=" + isNull + ", isAuto=" + isAuto + "]";
	}
	
}
