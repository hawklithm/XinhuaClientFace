package cn.mars.gxkl.protocol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
/*
 * ��������
 * ���Ӷ�����ɾ������
 * ������������ɾ��������
 * ������RFID��Ա����RFID��cubage��֪����ʲô����
 * ������RDID����������RFID��ʱ�䡢��Ϣ��
 */
public class HandleDetails {

	private Map<String, Object> condition;
	// ��Ϣ����ӣ��Ƴ���������ӡ������Ƴ�
	// ������RFid�š�Ա����Ա���š�������RFID
	final private String ITEM_INFO = "itemInfo", PACKAGE_INFO = "packageInfo",
			MACHINE_RFID = "machineRFID", STAFF_RFID = "staffRFID",
			TIME_STAMP = "timeStamp",SOURCE_TYPE = "sourceType";

	 final private String ITEM_ADD = "itemAdd", ITEM_REMOVE = "itemRemove",
	 PACKAGE_ADD = "packageAdd", PACKAGE_REMOVE = "packageRemove",
	 CUBAGE =
	 "cubage",
	 ITEM_RFIDS = "itemRFIDs", PACKAGE_RFIDS =
	 "packageRFIDs",MESSAGE="message";

	public void setMessage(String message) {
		condition.put(MESSAGE, message);
	}

	public String getMessage() {
		return (String) condition.get(MESSAGE);
	}
//
	public void setTimeStamp(Date time) {
		condition.put(TIME_STAMP, time);
	}

	public Date getTimeStamp() {
		return (Date) new Date((String) condition.get(TIME_STAMP));
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public HandleDetails(Map<String, Object> condition) {
		this.condition = condition;
	}
//
//	@SuppressWarnings("unchecked")
//	public List<Object> getItemAdd() {
//		return (List<Object>) condition.get(ITEM_ADD);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Object> getItemRemove() {
//		return (List<Object>) condition.get(ITEM_REMOVE);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Object> getPackageAdd() {
//		return (List<Object>) condition.get(PACKAGE_ADD);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Object> getPackageRemove() {
//		return (List<Object>) condition.get(PACKAGE_REMOVE);
//	}
//
	public Integer getMachineRfid() {
		// return new Integer.valueOf((Integer)condition.get(RFID));
		return (int) Float.parseFloat(condition.get(MACHINE_RFID).toString());
	}

	public Integer getStaffRFID() {
		return (int) Float.parseFloat(condition.get(STAFF_RFID).toString());
	}
//
//	public Integer getCubage() {
//		return (int) Float.parseFloat(condition.get(CUBAGE).toString());
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Object> getItemRFIDs() {
//		return (List<Object>) condition.get(ITEM_RFIDS);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Object> getPackageRFIDs() {
//		return (List<Object>) condition.get(PACKAGE_RFIDS);
//	}
	
	public List<Map<String,Object>> getItemInfo() {
		return (List<Map<String,Object>>)condition.get(ITEM_INFO);

	}
	
	public Integer[] getPackageInfo() {
		return (Integer[])condition.get(PACKAGE_INFO);
	}
	
	public String getSourceType() {
		return (String)condition.get(SOURCE_TYPE);
	}
	
}
