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
	private String RFID = "rfid", TYPE = "type", CREATE = "create",
			MODIFIED = "modified", REPAIR = "repair",
			MANUFACTURER = "manufacturer", DETAIL = "detail";

	public Equipment() {
		super();
	}

	public Equipment(Map<String, Object> condition) {
		super(condition);
	}

	public void setRFID(String rfid) {
		setProperty(RFID, rfid);
	}

	public String getRFID() {
		return (String) getProperty(RFID);
	}

	public void setTYPE(String type) {
		setProperty(TYPE, type);
	}

	public String getTYPE() {
		return (String) getProperty(TYPE);
	}

	public void setCREATE(String create) {
		setProperty(CREATE, create);
	}

	public String getCREATE() {
		return (String) getProperty(CREATE);
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

}
