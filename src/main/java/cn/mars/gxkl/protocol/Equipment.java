package cn.mars.gxkl.protocol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author afsd-pc 设备描述类 包含对应参数
 */
public class Equipment extends Protocol {
	private String MANUFACTURER = "manufacturer", DETAILTITEL = "detailtitel",
			DETAILVALUE = "detalvalue", ID = "id", NAME = "name",
			CAPACITY = "capacity", GMT_BUY = "gmtBuy",
			GMT_LAST_REPAIR = "gmtLastRepair",
			MACHINE_NUMBER = "machineNumber", EQUIPMENT_ID = "equipmentId",
			TYPE = "type", GMT_CREATE = "gmtCreate",
			GMT_MODIFIED = "gmtModified";

	public Equipment() {
		super();
	}

	public Equipment(Map<String, Object> condition) {
		super(condition);
	}

	public void setId(String rfid) {
		setProperty(ID, rfid);
	}

	public String getId() {
		return (String) getProperty(ID);
	}

	public void setType(String type) {
		setProperty(TYPE, type);
	}

	public String getType() {
		return (String) getProperty(TYPE);
	}

	public void setName(String name) {
		setProperty(NAME, name);
	}

	public String getName() {
		return (String) getProperty(NAME);
	}

	public void setCapacity(String capacity) {
		setProperty(CAPACITY, capacity);
	}

	public String getCapacity() {
		return (String) getProperty(CAPACITY);
	}

	public void setManufacturer(String manufacturer) {
		setProperty(MANUFACTURER, manufacturer);
	}

	public String getManufacturer() {
		return (String) getProperty(MANUFACTURER);
	}

	public void setDetailTitel(List<String> detailtitel) {
		setProperty(DETAILTITEL, detailtitel);
	}

	public List<String> getDetailTitel() {
		return (List<String>) getProperty(DETAILTITEL);
	}

	public void setDetailValue(List<String> detailvalue) {
		setProperty(DETAILVALUE, detailvalue);
	}

	public List<String> getDetailValue() {
		return (List<String>) getProperty(DETAILVALUE);
	}

	public Date getGmtBuy() {
		return (Date) getProperty(GMT_BUY);
	}

	public void setGmtBuy(Date gmtBuy) {
		setProperty(GMT_BUY, gmtBuy);
	}

	public Date getGmtLastRepair() {
		return (Date) getProperty(GMT_LAST_REPAIR);
	}

	public void setGmtLastRepair(Date gmtLastRepair) {
		setProperty(GMT_LAST_REPAIR, gmtLastRepair);
	}

	public String getMachineNumber() {
		return (String) getProperty(MACHINE_NUMBER);
	}

	public void setMachineNumber(String machineNumber) {
		setProperty(MACHINE_NUMBER, machineNumber);
	}

	public Integer getEquipmentId() {
		return (Integer) getProperty(EQUIPMENT_ID);
	}

	public void setEquipmentId(Integer equipmentId) {
		setProperty(EQUIPMENT_ID, equipmentId);
	}

	public Date getGmtCreate() {
		return (Date) getProperty(GMT_CREATE);
	}

	public void setGmtCreate(Date gmtCreate) {
		setProperty(GMT_CREATE, gmtCreate);
	}

	public Date getGmtModified() {
		return (Date) getProperty(GMT_MODIFIED);
	}

	public void setGmtModified(Date gmtModified) {
		setProperty(GMT_MODIFIED, gmtModified);
	}

}
