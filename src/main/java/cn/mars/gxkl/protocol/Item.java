package cn.mars.gxkl.protocol;

import java.util.Map;

public class Item extends Protocol {
	
	private String NAME = "name",RFID = "rfid",PROCEDURE = "procedure",PROCESS = "process",HISTORY = "history";
	
	public Item() {
		super();
	}
	
	public Item(Map<String,Object> condition) {
		super(condition);
	}
	
	public String getName() {
		return (String)getProperty(NAME);
	}
	
	public String getRFID() {
		return (String)getProperty(RFID);
	}
	
	public String getProcess() {
		return (String)getProperty(PROCESS);
	}
	
	public String getProcedure() {
		return (String)getProperty("procedure");
	}
	public String getHistory() {
		return (String)getProperty(HISTORY);
	}
	
	public void setCondition(Map<String,Object> condition) {
		super.setCondition(condition);
	}
}
