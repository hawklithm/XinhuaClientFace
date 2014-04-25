package com.multiagent.hawklithm.item.dataobject;

import java.util.Date;
import java.util.Map;

public class ItemInfoDO {  //∂©µ•–≈œ¢
	private Integer itemId;
	private Date gmtCreate;
	private Date gmtModified;
	private String itemName;
	private Integer itemType;
	private Integer hospitalId;
	private String manufacturer;
	private boolean interconvertible;
	private String remark;
	private int status;
	
	public ItemInfoDO(){}
	
	public ItemInfoDO(Map<String,Object> map) {
		this.setGmtCreate(new Date(map.get("gmtCreate").toString()));
		this.setGmtModified(new Date(map.get("gmtModified").toString()));
		this.setHospitalId((Integer)map.get("hospitalId"));
		this.setInterconvertible((boolean)map.get("interconvertible"));
		this.setItemId((int) Float.parseFloat(map.get("itemId").toString()));
		this.setItemName((String)map.get("itemName"));
		this.setItemType((int) Float.parseFloat(map.get("itemType").toString()));
		this.setManufacturer((String)map.get("manufacturer"));
		this.setRemark((String)map.get("remark"));
		this.setStatus((int) Float.parseFloat(map.get("status").toString()));
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public boolean isInterconvertible() {
		return interconvertible;
	}
	public void setInterconvertible(boolean interconvertible) {
		this.interconvertible = interconvertible;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
