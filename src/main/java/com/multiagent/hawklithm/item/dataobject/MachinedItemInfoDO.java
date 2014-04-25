package com.multiagent.hawklithm.item.dataobject;

import java.util.Map;

public class MachinedItemInfoDO extends ItemInfoDO {
	
	private Integer machineId = 0;

	public MachinedItemInfoDO() {};
	
	public MachinedItemInfoDO(Map<String,Object> map) {
		super(map);
	}
	
	public MachinedItemInfoDO(Map<String,Object> map, Integer machineId) {
		this(map);
		this.machineId = machineId;
	}
	
	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}
	
}
