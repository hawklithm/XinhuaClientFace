package cn.mars.gxkl.protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontEndingCommunicationProtocol<T> extends Protocol {

	private static final String OPERATE_TYPE = "operateType",
			TABLE_TYPE = "tableType", STATUS = "status",
			LENGTH = "lengths", OFFSET = "offset", RETURN_STATE_OK = "ok",
			RETURN_STATE_FAIL_STRING = "fail";
	
	private List<T> rows = new ArrayList<T>();
	
	public FrontEndingCommunicationProtocol() {
		super();
	}
	
	public FrontEndingCommunicationProtocol(Map<String, Object> condition) {
		super(condition);
	}

	public Map<String, Object> getCondition() {
		return super.getCondition();
	}

	public void setCondition(Map<String, Object> condition) {
		super.setCondition(condition);
	}

	public String getTableName() {
		return (String)getProperty(TABLE_TYPE);
	}

	public String getOperateType() {
		return (String)getProperty(OPERATE_TYPE);
	}

	public String getStatus() {
		return (String)getProperty(STATUS);
	}

	public void setStatusOk() {
		setProperty(STATUS, RETURN_STATE_OK);
	}

	public void setStatusFail() {
		setProperty(STATUS, RETURN_STATE_FAIL_STRING);
	}

	public Integer getLength() {
		return (Integer)getProperty(LENGTH);
	}

	public Integer getOffset() {
		return (Integer)getProperty(OFFSET);
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
