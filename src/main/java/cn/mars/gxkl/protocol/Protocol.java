package cn.mars.gxkl.protocol;

import java.util.HashMap;
import java.util.Map;

public abstract class Protocol {
	
	private Map<String, Object> condition = new HashMap<String,Object>();
	
	public Protocol() {}
	
	public Protocol(Map<String,Object> condition) {
		this.condition = condition;
	}
	
	public void setCondition(Map<String,Object> condition) {
		this.condition = condition;
	}
	
	public Map<String, Object> getCondition() {
		return condition;
	}
	
	public Object getProperty(String property) {
		return condition.get(property);
	}
	
	public void setProperty(String property,Object value) {
		condition.put(property, value);
	}
}
