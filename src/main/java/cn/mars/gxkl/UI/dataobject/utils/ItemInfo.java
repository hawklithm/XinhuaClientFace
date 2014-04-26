package cn.mars.gxkl.UI.dataobject.utils;

import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

public interface ItemInfo {
	public MachinedItemInfoDO[] getItemByMachineRfid(String machineRfid);
	public MachinedItemInfoDO[] getAllItem();
}
