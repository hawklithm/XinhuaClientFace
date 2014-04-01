package cn.mars.gxkl.protocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author afsd-pc
 * 设备描述类
 * 包含对应参数
 */
public class Equipment extends Protocol {
	private String MODIFIED = "modified", REPAIR = "repair", MANUFACTURER = "manufacturer",
			DETAIL = "detail", ID = "id", GMT_BUY = "gmtBuy", GMT_LAST_REPAIR = "gmtLastRepair",
			MACHINE_NUMBER = "machineNumber", EQUIPMENT_ID = "equipmentId", TYPE = "type",
			GMT_CREATE="gmtCreate",GMT_MODIFIED="gmtModified";

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

	public void setTYPE(String type) {
		setProperty(TYPE, type);
	}

	public String getTYPE() {
		return (String) getProperty(TYPE);
	}


	public void setMODIFIED(String modified) {
		setProperty(MODIFIED, modified);
	}

	public String getMODIFIED() {
		return (String) getProperty(MODIFIED);
	}

	public void setREPAIR(String repair) {
		setProperty(REPAIR, repair);
	}

	public String getREPAIR() {
		return (String) getProperty(REPAIR);
	}

	public void setMANUFACTURER(String manufacturer) {
		setProperty(MANUFACTURER, manufacturer);
	}

	public String getMANFACTURER() {
		return (String) getProperty(MANUFACTURER);
	}

	public void setDETAIL(String detail) {
		List<String> detailList=new ArrayList<String>();
		int i=0;
		int j=0;
		while(detail.indexOf("\n", i)>=0){
			j=detail.indexOf("\n", i);
			detailList.add(detail.substring(i,j));
			i=j+1;
		}
		if(i<detail.length()){
			detailList.add(detail.substring(i));
		}
		setProperty(DETAIL, detailList);
	}
	public List<String> getDETAIL(){
		return (List<String>) getProperty(DETAIL);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getGMT_BUY() {
		return GMT_BUY;
	}

	public void setGMT_BUY(String gMT_BUY) {
		GMT_BUY = gMT_BUY;
	}

	public String getGMT_LAST_REPAIR() {
		return GMT_LAST_REPAIR;
	}

	public void setGMT_LAST_REPAIR(String gMT_LAST_REPAIR) {
		GMT_LAST_REPAIR = gMT_LAST_REPAIR;
	}

	public String getMACHINE_NUMBER() {
		return MACHINE_NUMBER;
	}

	public void setMACHINE_NUMBER(String mACHINE_NUMBER) {
		MACHINE_NUMBER = mACHINE_NUMBER;
	}

	public String getEQUIPMENT_ID() {
		return EQUIPMENT_ID;
	}

	public void setEQUIPMENT_ID(String eQUIPMENT_ID) {
		EQUIPMENT_ID = eQUIPMENT_ID;
	}

	public String getMANUFACTURER() {
		return MANUFACTURER;
	}

	public String getGMT_CREATE() {
		return GMT_CREATE;
	}

	public void setGMT_CREATE(String gMT_CREATE) {
		GMT_CREATE = gMT_CREATE;
	}

	public String getGMT_MODIFIED() {
		return GMT_MODIFIED;
	}

	public void setGMT_MODIFIED(String gMT_MODIFIED) {
		GMT_MODIFIED = gMT_MODIFIED;
	}

}
