package cn.mars.gxkl.protocol;

import java.util.HashMap;
import java.util.Map;

public abstract class Protocol {
	//协议通过的Map,通过标记，来最终查找对应的实际内容
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
