package cn.mars.gxkl.protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveMessageProtocol {
	
	Map<String,Object> condition;//信息协议，包括流程名称，流程的ID,处理的具体信息
	
	
	final private String PROCESSNAME = "processName",ID = "id",RETVALUE = "retValue";
	
	public LiveMessageProtocol() {
		condition = new HashMap<String, Object>();
	}
	
	public String getProcessName() {
		return condition.get(PROCESSNAME).toString();
	}
	
	public void setProcessName(String processName) {
		condition.put(PROCESSNAME,processName);
	}
	public int getId() {
		return Integer.parseInt(condition.get(ID).toString());
	}
	public void setId(int id) {
		condition.put(ID, ""+id);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Map<String,Object>> getRetValue() {
		return (ArrayList<Map<String,Object>>)condition.get(RETVALUE);
	}
	public void setRetValue(List<HandleDetails> retValue) {
		condition.put(RETVALUE, retValue);
	}
}
