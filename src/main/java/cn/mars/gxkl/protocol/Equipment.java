package cn.mars.gxkl.protocol;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author afsd-pc 设备描述类 包含对应参数
 * 生产厂家
 * 详情
 * 价格
 * 购买日期
 * 数量
 *ID
 *类型
 *表的创建时间
 *表的更新时间
 */
public class Equipment extends Protocol {
	private String MANUFACTURER = "manufacturer", DETAIL = "detail",
			DETAILVALUE = "detalvalue", ID = "id", NAME = "name",
			CAPACITY = "capacity", GMT_BUY = "gmtBuy",
			GMT_LAST_REPAIR = "gmtLastRepair",
			MACHINE_NUMBER = "machineNumber", EQUIPMENT_ID = "equipmentId",
			TYPE = "equipmentType", GMT_CREATE = "gmtCreate",
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
		Object ans=getProperty(ID);
		if (ans instanceof Double){
			return String.valueOf(((Double)getProperty(ID)).intValue());
		}
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
	public void setDetail(String detail){
		
	}
	public String getDetail(){
		String detail="";
		return detail;
	}
	public void setDetailTitel(List<String> detailtitel) {
		setProperty(DETAIL, detailtitel);
	}

	public List<String> getDetailTitel() {
		return (List<String>) getProperty(DETAIL);
	}

	public void setDetailValue(List<String> detailvalue) {
		setProperty(DETAILVALUE, detailvalue);
	}

	public List<String> getDetailValue() {
		return (List<String>) getProperty(DETAILVALUE);
	}

	public Date getGmtBuy() {
		return changeToDate(getProperty(GMT_BUY));
	}

	public void setGmtBuy(Date gmtBuy) {
		setProperty(GMT_BUY, gmtBuy);
	}

	public Date getGmtLastRepair() {
		return changeToDate(getProperty(GMT_LAST_REPAIR));
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
		Object object=getProperty(EQUIPMENT_ID);
		if (object instanceof Double){
			return ((Double)object).intValue();
		}
		if (object instanceof Integer){
			return (Integer)object;
		}
		return null;
	}

	public void setEquipmentId(Integer equipmentId) {
		setProperty(EQUIPMENT_ID, equipmentId);
	}

	public Date getGmtCreate() {
		return changeToDate(getProperty(GMT_CREATE));
	}
	
	private Date changeToDate(Object date){
		if (date instanceof String){
			return new Date((String)date);
		}else if (date instanceof Date){
			return (Date)date;
		}else {
			return null;
		}
	}

	public void setGmtCreate(Date gmtCreate) {
		setProperty(GMT_CREATE, gmtCreate);
	}

	public Date getGmtModified() {
		return changeToDate(getProperty(GMT_MODIFIED));
	}

	public void setGmtModified(Date gmtModified) {
		setProperty(GMT_MODIFIED, gmtModified);
	}

}
